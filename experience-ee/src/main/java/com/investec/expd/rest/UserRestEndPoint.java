package com.investec.expd.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.investec.expd.model.User;
import com.investec.expd.rest.dto.UserDTO;

@Stateless
@Path("user")
public class UserRestEndPoint {

	@PersistenceContext(unitName = "experienceDS")
	private EntityManager em;

	@GET
	@Produces("application/json")
	public List<UserDTO> listAll() {

		TypedQuery<User> findAllQuery = em.createNamedQuery("user.FindAll", User.class);
		final List<User> searchResults = findAllQuery.getResultList();
		final List<UserDTO> results = new ArrayList<UserDTO>();

		for (User searchResult : searchResults) {
			UserDTO dto = new UserDTO(searchResult);
			results.add(dto);

		}

		return results;

	}

}
