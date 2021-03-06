package org.hpccsystems.ws.client;

import java.util.ArrayList;
import java.util.List;

import org.hpccsystems.ws.client.platform.ApplicationValueInfo;
import org.hpccsystems.ws.client.platform.Cluster;
import org.hpccsystems.ws.client.platform.Platform;
import org.hpccsystems.ws.client.platform.QueryResult;
import org.hpccsystems.ws.client.platform.QuerySetFilterType;
import org.hpccsystems.ws.client.platform.WUQueryInfo;
import org.hpccsystems.ws.client.platform.WUQueryInfo.SortBy;
import org.hpccsystems.ws.client.platform.WUState;
import org.hpccsystems.ws.client.platform.WorkunitInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public abstract class BaseWsWorkunitsClientIntegrationTest {

    Platform platform;
    HPCCWsClient client1;
    HPCCWsWorkUnitsClient client;
    Cluster thorcluster;
    Cluster roxiecluster;
    Cluster hthorcluster;
    List<String> testwuids=new ArrayList<String>();
    String uniquerun="";
    
    protected abstract Platform getPlatform() throws Exception;
    protected abstract String getThorClusterName();
    protected abstract String getRoxieClusterName();
    protected abstract String getHthorClusterName();
    
    @Before
    public void setup() throws Exception
    {
        platform= getPlatform();
        thorcluster=platform.getCluster(getThorClusterName());
        roxiecluster =platform.getCluster(getRoxieClusterName());
        hthorcluster=platform.getCluster(getHthorClusterName());
        
        try 
        {
            client1 = platform.checkOutHPCCWsClient();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        client=client1.getWsWorkunitsClient();
    }
 

    @After
    public void shutdown() 
    {
        for (String wuid:testwuids)
        {
            try {
                System.out.println("Deleting test wuid " + wuid);
                client.deleteWU(wuid);
            } catch (Exception e)
            {
                System.out.println("Could not delete test wuid " + wuid + ":" + e.getMessage());
                e.printStackTrace();
            }
        }
        if (platform != null && client != null)
        {
            try 
            {
                platform.checkInHPCCWsClient(client1);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        
    }
    
    @Test
    public void testSearchQueries() throws Exception
    {
        List<QueryResult> resultsArray= client.searchQueries(null, null, roxiecluster.getName(), roxiecluster.getName());
        if (resultsArray==null || resultsArray.size()==0)
        {
            Assert.fail("Should have returned queries");
        }
        System.out.println(resultsArray.get(0).toString());
        String queryid=resultsArray.get(0).getId();
        String queryname=resultsArray.get(0).getName();
        List<QueryResult> resultsArr2=client.searchQueries(QuerySetFilterType.Name, queryname, roxiecluster.getName(),roxiecluster.getName());
        if (resultsArr2==null || resultsArr2.size() != 1)
        {
            Assert.fail("Should have returned one query for query named " + queryname);
        }
        List<QueryResult> resultsArr3=client.searchQueries(QuerySetFilterType.Id, queryid,roxiecluster.getName(),roxiecluster.getName());
        if (resultsArr3==null || resultsArr3.size() != 1)
        {
            Assert.fail("Should have returned one query for query with id " + queryid);
        }
        
    }
    
    protected void createTestWorkunits(String ecl,int num) throws Exception
    {
        this.uniquerun=String.valueOf(System.currentTimeMillis());
        for (int i=1;i <=num;i++)
        {
            WorkunitInfo wu=new WorkunitInfo();
            wu.setECL(ecl);
            wu.setCluster(thorcluster.getName());
            wu.setJobname("testgetworkunit-" + i + "-" + uniquerun);
            wu.setOwner("dleed");
            wu.getApplicationValues().add(new ApplicationValueInfo("HIPIE","testkey","testvalue"));
            wu.getApplicationValues().add(new ApplicationValueInfo("HIPIE","testkey2","testvalue" + i));
            wu.getApplicationValues().add(new ApplicationValueInfo("HIPIE","uniquetestkey" + i,"uniquetestvalue" + i));

            wu=client.compileWUFromECL(wu);
            WorkunitInfo res=client.getWUInfo(wu.getWuid());
            //6.0 has state compiled; 5.x has state completed
            if (!res.getState().equals(WUState.COMPILED.toString().toLowerCase())
                    && !res.getState().equals(WUState.COMPLETED.toString().toLowerCase()))
            {
                System.out.println(res.toString());
                Assert.fail("Workunit " + i + " didn't compile correctly");
            }
            wu=client.runWorkunit(wu.getWuid(),null,null,5000,false,null);
            WorkunitInfo wu2=client.getWUInfo(wu.getWuid());
            if (!wu2.getState().equals(WUState.COMPLETED.toString().toLowerCase())
                    && !wu2.getState().equals(WUState.RUNNING.toString().toLowerCase()))
            {
                System.out.println(wu2.toString());
                Assert.fail("Workunit didn't run correctly");
            }
            testwuids.add(wu.getWuid());
        }
        
    }
    @Test
    public void testGetWorkunitByAppValue() throws Exception
    {
        createTestWorkunits("OUTPUT(1);",2);
        WUQueryInfo params=new WUQueryInfo().setJobname("*" + uniquerun + "*");
        params.getApplicationValues().add(new ApplicationValueInfo("HIPIE","testkey","testvalue"));
        List<WorkunitInfo> result=client.getWorkunits(params);
        if (result.size() != 2)
        {
            System.out.println(result);
            Assert.fail("should have been two workunits with app value named testkey with value testvalue");
        }
        params.getApplicationValues().add(new ApplicationValueInfo("HIPIE","testkey2","testvalue1"));
        result=client.getWorkunits(params);
        if (result.size() != 1)
        {
            System.out.println(result);
            Assert.fail("should have been one workunits with app value named testkey with value testvalue and "
                    + "app value named testkey2 with testvalue1");
        }

    }

    @Test
    public void testGetWorkunitSort() throws Exception {

        //wuid descending
        List<WorkunitInfo> result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.WUID).setDescending(true));
        if (result.get(0).getWuid().compareTo(result.get(1).getWuid())<0) {
            Assert.fail("descending workunits in wrong order:" + result.get(0).getWuid() + " then " + result.get(1).getWuid());
        }
        //wuid ascending
        result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.WUID).setDescending(false));
        if (result.get(1).getWuid().compareTo(result.get(0).getWuid())<0) {
            Assert.fail("ascending workunits in wrong order:" + result.get(0).getWuid() + " then " + result.get(1).getWuid());
        }
        
      //cluster descending
        result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.Cluster).setDescending(true));
        if (result.get(0).getCluster().compareTo(result.get(result.size()-1).getCluster())<0) {
            Assert.fail("descending clusters in wrong order:" + result.get(0).getCluster() + " then " 
                    + result.get(result.size()-1).getCluster());
        }
        //cluster ascending
        result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.Cluster).setDescending(false));
        if (result.get(1).getCluster().compareTo(result.get(0).getCluster())<0) {
            Assert.fail("ascending clusters in wrong order:" + result.get(0).getCluster() + " then " 
                    + result.get(result.size()-1).getCluster());
        }
        
        //jobname descending
        result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.Jobname).setDescending(true));
        if (result.get(0).getJobname().compareTo(result.get(result.size()-1).getJobname())<0) {
            Assert.fail("descending jobname in wrong order:" + result.get(0).getJobname() + " then " 
                    + result.get(result.size()-1).getJobname());
        }
        //jobname ascending
        result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.Jobname).setDescending(false));
        if (result.get(1).getJobname().compareTo(result.get(0).getJobname())<0) {
            Assert.fail("ascending jobname in wrong order:" + result.get(0).getJobname() + " then " 
                    + result.get(result.size()-1).getJobname());
        }

        //owner descending
        result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.Owner).setDescending(true));
        if (result.get(0).getOwner().compareTo(result.get(result.size()-1).getOwner())<0) {
            Assert.fail("descending owner in wrong order:" + result.get(0).getOwner() + " then " 
                    + result.get(result.size()-1).getOwner());
        }
        //owner ascending
        result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.Owner).setDescending(false));
        if (result.get(1).getOwner().compareTo(result.get(0).getOwner())<0) {
            Assert.fail("ascending owner in wrong order:" + result.get(0).getOwner() + " then " 
                    + result.get(result.size()-1).getOwner());
        }
        
        //state descending
        result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.State).setDescending(true));
        if (result.get(0).getState().compareTo(result.get(result.size()-1).getState())<0) {
            Assert.fail("descending state in wrong order:" + result.get(0).getState() + " then " 
                    + result.get(result.size()-1).getState());
        }
        //state ascending
        result=client.getWorkunits(new WUQueryInfo().setSortBy(SortBy.State).setDescending(false));
        if (result.get(1).getState().compareTo(result.get(0).getState())<0) {
            Assert.fail("ascending state in wrong order:" + result.get(0).getState() + " then " 
                    + result.get(result.size()-1).getState());
        }

        
    }
 

    @Test
    public void testAbortWU() throws Exception
    {
        createTestWorkunits("OUTPUT( PIPE('sleep 10',{STRING hack}));",1);
        if (this.testwuids.size()==0)
        {
            Assert.fail("workunit not created");
        }
        client.abortWU(testwuids.get(0));
        Thread.sleep(5000);
        WorkunitInfo test=client.getWUInfo(testwuids.get(0));
        if (!(WUState.ABORTED.toString().toLowerCase().equals(test.getState())
                || WUState.ABORTING.toString().toLowerCase().equals(test.getState())))
        {
            Assert.fail("Workunit not aborted");
        }
    }

}

