package card.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import card.dao.CardDao;
import card.model.CardBean;
import init.HibernateUtils;

public class CardDaoImpl implements Serializable, CardDao {


	private static final long serialVersionUID = 1L;
//	private int recordsPerPage = 8;
//	private int totalPages = -1;

    SessionFactory factory;
    
	public CardDaoImpl(){
        factory = HibernateUtils.getSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getCbPageCards() {
        Map<Integer, CardBean> map = new HashMap<>();
		
		List<CardBean> list = new ArrayList<CardBean>();
		String hql = "FROM CardBean c WHERE c.fcb > 0 AND c.dcb >0";
        Session session = factory.getCurrentSession();

//        int startRecordNo = (pageNo - 1) * recordsPerPage;

        list = session.createQuery(hql)
//                      .setFirstResult(startRecordNo)
//                      .setMaxResults(recordsPerPage)
                      .getResultList();
        for(CardBean bean : list) {
        	map.put(bean.getC_id(), bean);
        }
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getMlPageCards() {
		  Map<Integer, CardBean> map = new HashMap<>();
			
			List<CardBean> list = new ArrayList<CardBean>();
			String hql = "FROM CardBean c WHERE c.fma LIKE 'NT%' OR c.dma LIKE 'NT%'";
	        Session session = factory.getCurrentSession();

//	        int startRecordNo = (pageNo - 1) * recordsPerPage;

	        list = session.createQuery(hql)
//	                      .setFirstResult(startRecordNo)
//	                      .setMaxResults(recordsPerPage)
	                      .getResultList();
	        for(CardBean bean : list) {
	        	map.put(bean.getC_id(), bean);
	        }
			return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getOilPageCards() {
		  Map<Integer, CardBean> map = new HashMap<>();
			
			List<CardBean> list = new ArrayList<CardBean>();
			String hql = "FROM CardBean c WHERE c.refuel_dis LIKE 'NT%' OR refuel_cb > 0.0001";
	        Session session = factory.getCurrentSession();

//	        int startRecordNo = (pageNo - 1) * recordsPerPage;

	        list = session.createQuery(hql)
//	                      .setFirstResult(startRecordNo)
//	                      .setMaxResults(recordsPerPage)
	                      .getResultList();
	        for(CardBean bean : list) {
	        	map.put(bean.getC_id(), bean);
	        }
			return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getMvPageCards() {
		  Map<Integer, CardBean> map = new HashMap<>();
			
			List<CardBean> list = new ArrayList<CardBean>();
			String hql = "FROM CardBean c WHERE wkdmoviedis LIKE '%折' OR moviedis LIKE '%折'";
	        Session session = factory.getCurrentSession();

//	        int startRecordNo = (pageNo - 1) * recordsPerPage;

	        list = session.createQuery(hql)
//	                      .setFirstResult(startRecordNo)
//	                      .setMaxResults(recordsPerPage)
	                      .getResultList();
	        for(CardBean bean : list) {
	        	map.put(bean.getC_id(), bean);
	        }
			return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getOsPageCards() {
		  Map<Integer, CardBean> map = new HashMap<>();
			
			List<CardBean> list = new ArrayList<CardBean>();
			String hql = "FROM CardBean c WHERE c.onlinefb >0.001";
	        Session session = factory.getCurrentSession();

//	        int startRecordNo = (pageNo - 1) * recordsPerPage;

	        list = session.createQuery(hql)
//	                      .setFirstResult(startRecordNo)
//	                      .setMaxResults(recordsPerPage)
	                      .getResultList();
	        for(CardBean bean : list) {
	        	map.put(bean.getC_id(), bean);
	        }
			return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getZiPageCards() {
		  Map<Integer, CardBean> map = new HashMap<>();
			
			List<CardBean> list = new ArrayList<CardBean>();
			String hql = "FROM CardBean c WHERE c.zeroins LIKE '%期'";
	        Session session = factory.getCurrentSession();

//	        int startRecordNo = (pageNo - 1) * recordsPerPage;

	        list = session.createQuery(hql)
//	                      .setFirstResult(startRecordNo)
//	                      .setMaxResults(recordsPerPage)
	                      .getResultList();
	        for(CardBean bean : list) {
	        	map.put(bean.getC_id(), bean);
	        }
			return map;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getAllCards() {
		  Map<Integer, CardBean> map = new HashMap<>();
			
			List<CardBean> list = new ArrayList<CardBean>();
			String hql = "FROM CardBean";
	        Session session = factory.getCurrentSession();

	       

	        list = session.createQuery(hql)
	                 
	                      .getResultList();
	        for(CardBean bean : list) {
	        	map.put(bean.getC_id(), bean);
	        }
			return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getFgPageCards() {
		    Map<Integer, CardBean> map = new HashMap<>();
			
			List<CardBean> list = new ArrayList<CardBean>();
			String hql = "FROM CardBean c WHERE c.cashfb LIKE '%0' OR mileagefb LIKE '%里'";
	        Session session = factory.getCurrentSession();

//	        int startRecordNo = (pageNo - 1) * recordsPerPage;

	        list = session.createQuery(hql)
//	                      .setFirstResult(startRecordNo)
//	                      .setMaxResults(recordsPerPage)
	                      .getResultList();
	        for(CardBean bean : list) {
	        	map.put(bean.getC_id(), bean);
	        }
			return map;
	}
	   @Override
	   public CardBean getCard(int c_id){
	        CardBean bean = null;
	        Session session = factory.getCurrentSession();
	        bean = session.get(CardBean.class, c_id);
	        return bean;
	    }

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getModalBean(String hql) {
	    Map<Integer, CardBean> map = new HashMap<>();
		List<CardBean> list = new ArrayList<CardBean>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql)
		 .setFirstResult(0)
         .setMaxResults(3)
         .getResultList();
		  for(CardBean bean : list) {
	        	map.put(bean.getC_id(), bean);
	        }
		return map;
	 }
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, CardBean> getRandomBean() {
		Set<String> set = new HashSet<String>();
		while(set.size()<10) {
			int cid= (int)(Math.random()*296 + 1);
			String cId= Integer.toString(cid);
			set.add(cId);
		}
		Iterator<String> it = set.iterator();
		String ql ="";
		int count =0;
		while(it.hasNext()) {
			if(count<1) {
			ql = "c.c_id = " + it.next();
			}
			else {
			ql=ql +" or c.c_id = "+ it.next();}
			count++;
		}
		
			Map<Integer, CardBean> map = new HashMap<>();
			
			List<CardBean> list = new ArrayList<CardBean>();
			ql = "FROM CardBean c WHERE " + ql;
	        Session session = factory.getCurrentSession();

	        list = session.createQuery(ql).getResultList();
                      
	        for(CardBean bean : list) {
	        	map.put(bean.getC_id(), bean);
	        }
			return map;
	}
	
}
