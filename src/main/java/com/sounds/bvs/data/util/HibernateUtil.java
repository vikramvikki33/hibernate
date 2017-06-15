package com.sounds.bvs.data.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private HibernateUtil() {
	}

	private static SessionFactory buildSessionFactory() {
		if (sessionFactory == null) {
			final StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();

			final Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();

			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}

	/**
	 * @return sessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
