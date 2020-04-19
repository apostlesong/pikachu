package card.service.impl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import card.dao.CardDao;
import card.dao.impl.CardDaoImpl;
import card.model.CardBean;
import card.service.CardService;
import init.HibernateUtils;

public class CardServiceImpl implements CardService {
	
	CardDao dao;
	SessionFactory factory;
	
	public CardServiceImpl() {
		dao =  new CardDaoImpl();
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Map<Integer, CardBean> getCbPageCards() {
		Map<Integer, CardBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getCbPageCards();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
	}

	@Override
	public Map<Integer, CardBean> getMlPageCards() {
		Map<Integer, CardBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getMlPageCards();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
	}

	@Override
	public Map<Integer, CardBean> getOilPageCards() {
		Map<Integer, CardBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getOilPageCards();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
	}

	@Override
	public Map<Integer, CardBean> getMvPageCards() {
		Map<Integer, CardBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getMvPageCards();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
	}

	@Override
	public Map<Integer, CardBean> getOsPageCards() {
		Map<Integer, CardBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getOsPageCards();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
	}

	@Override
	public Map<Integer, CardBean> getZiPageCards() {
		Map<Integer, CardBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getZiPageCards();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
	}

	@Override
	public Map<Integer, CardBean> getFgPageCards() {
		Map<Integer, CardBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getFgPageCards();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
	}
	
	
	@Override
	public Map<Integer, CardBean> getAllCards(){
		Map<Integer, CardBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getAllCards();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
		
	}

	@Override
	public CardBean getCard(int c_id) {
		CardBean bean = null;

		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = dao.getCard(c_id);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return bean;
		
	}

	@Override
	public Map<Integer, CardBean> getModalBean(String hql) {
		Map<Integer, CardBean> map = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			map = dao.getModalBean(hql);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return map;
		
	}
	
}
