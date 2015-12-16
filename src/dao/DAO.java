/*
 * Classe abstraite générique 
 * pour intéragir avec les tables
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package dao;

import java.sql.Connection;

import connexion.SingletonConnection;

public abstract class DAO<T> {
	
	public Connection connection = SingletonConnection.getConnection();
	
	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T find(int id);
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract T create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public abstract T update(T obj);
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);
}
