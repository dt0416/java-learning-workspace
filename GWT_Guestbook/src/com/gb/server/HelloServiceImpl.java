package com.gb.server;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.gb.PMF;
import com.gb.PersistenceContact;
import com.gb.client.HelloService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * 1. 實作RPC
 * 2. 示範Datastore的功能
 * 
 * @author Ian Chen
 *
 */
public class HelloServiceImpl extends RemoteServiceServlet implements
        HelloService {

    @Override
    public String hello(String name) {

    	this.save();
//    	this.delete();
    	
    	// 使用字串
//    	this.queryByString();
//    	this.queryIdByString();
//    	this.queryUseParameterByString();
    	
    	// 使用JDO
//    	this.queryByJdo();
//    	this.queryIdByJdo();
//    	this.queryFilterByJdo();
//    	this.queryUseParameterByJdo();
//    	this.querySortByJdo();
    	
        return "Hello, " + name;
    }
    
    /**
     * 新增-利用PersistenceManager新增資料測試，可於http://127.0.0.1:8888/_ah/admin/驗證
     */
    private void save() {
    	System.out.println("save");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        PersistenceContact tom = new PersistenceContact("Tom", "tom@jo87.com", "台北市中山區xx號");
        pm.makePersistent(tom);
        pm.close();
        System.out.println("寫入資料成功");
    }

    /**
     * 查詢-整個Entity過濾並排序
     * 字串方式
     */
    private void queryByString() {
    	System.out.println("queryByString");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery("SELECT FROM " + PersistenceContact.class.getName() + " WHERE name == 'Tom' ORDER BY name ");
        List<PersistenceContact> result = (List<PersistenceContact>) query.execute();
        for (PersistenceContact contact : result ){
            System.out.println(contact.getEmail());
        }
        pm.close();
    }
    
    /**
     * 查詢-實體鍵值(單一欄位)
     * 字串方式
     */
    private void queryIdByString() {
    	System.out.println("queryIdByString");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery("SELECT name FROM " + PersistenceContact.class.getName() + " WHERE name == 'Tom'");
        List ids = (List) query.execute();
        for (Object id : ids ){
            System.out.println(id);
        }
        pm.close();
    }
    
    /**
     * 查詢-利用字串作為參數使用
     * 字串方式
     */
    private void queryUseParameterByString() {
    	System.out.println("queryUseParameterByString");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery("SELECT FROM " + PersistenceContact.class.getName() + " WHERE name == p PARAMETERS String p");
        List<PersistenceContact> result = (List<PersistenceContact>) query.execute("Tom");
        for (PersistenceContact contact : result ){
            System.out.println(contact.getEmail());
        }
        pm.close();
    }
    
    /**
     * 查詢-所有Entity
     * JDO的方法
     */
    private void queryByJdo() {
    	System.out.println("queryByJdo");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(PersistenceContact.class);
        List<PersistenceContact> result = (List<PersistenceContact>) query.execute();
        for (PersistenceContact contact : result ){
            System.out.println(contact.getEmail());
        }
        pm.close();
    }
    
    /**
     * 查詢-實體鍵值(單一欄位)
     * 字串方式
     */
    private void queryIdByJdo() {
    	System.out.println("queryIdByJdo");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(PersistenceContact.class);
        query.setResult("id");
        List ids = (List) query.execute();
        for (Object id : ids ){
            System.out.println(id);
        }
        pm.close();
    }
    
    /**
     * 查詢-過濾
     * JDO的方法
     */
    private void queryFilterByJdo() {
    	System.out.println("queryFilterByJdo");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(PersistenceContact.class);
        query.setFilter("name=='Tom'");
        List<PersistenceContact> result = (List<PersistenceContact>) query.execute();
        for (PersistenceContact contact : result ){
            System.out.println(contact.getEmail());
        }
        pm.close();
    }
    
    /**
     * 查詢-利用字串作為參數使用
     * JDO的方法
     */
    private void queryUseParameterByJdo() {
    	System.out.println("queryUseParameterByJdo");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(PersistenceContact.class);
        query.setFilter("name==p");
        query.declareParameters("String p");
        List<PersistenceContact> result = (List<PersistenceContact>) query.execute("Tom");
        for (PersistenceContact contact : result ){
            System.out.println(contact.getEmail());
        }
        pm.close();
    }
    
    /**
     * 查詢-排序
     * JDO的方法
     */
    private void querySortByJdo() {
    	System.out.println("querySortByJdo");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(PersistenceContact.class);
        query.setOrdering("name ascending"); // ascending為昇冪，descending為降冪
        List<PersistenceContact> result = (List<PersistenceContact>) query.execute();
        for (PersistenceContact contact : result ){
            System.out.println(contact.getEmail());
        }
        pm.close();
    }
    
    /**
     * 刪除
     */
    private void delete() {
    	System.out.println("delete");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(PersistenceContact.class);
        List<PersistenceContact> result = (List<PersistenceContact>) query.execute();
        for (PersistenceContact contact : result ){
            pm.deletePersistent(contact);
        }
        pm.close();
    }
}
