package com.investec.expd.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.investec.expd.model.Idea;
import com.investec.expd.rest.dto.IdeaDTO;

@Stateless
@Path("idea")
public class IdeaRestEndpoint {
	@PersistenceContext(unitName = "experienceDS")
	private EntityManager em;
	
	@GET
	@Produces("application/json")
	@Path("/getall")
	public List<IdeaDTO> listAll() {
		
		TypedQuery<Idea> findAllQuery = em.createNamedQuery("idea.FindAll", Idea.class);
		final List<Idea> searchResults = findAllQuery.getResultList();
		final List<IdeaDTO> results = new ArrayList<IdeaDTO>();
		
		for (Idea idea : searchResults) {
			IdeaDTO dto=new IdeaDTO(idea);
			results.add(dto);
			
		}
		
		return results;
	}
	
	@POST
	@Path("/create")
	public void create(IdeaDTO ideaDTO){
		Idea idea = ideaDTO.fromIdeaDTO(null,em);
		em.persist(idea);
	}

}
