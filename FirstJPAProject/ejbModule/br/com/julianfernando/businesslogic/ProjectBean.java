package br.com.julianfernando.businesslogic;

import java.util.List;

import br.com.julianfernando.business.IProject;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.br.julianfernando.entities.Project;

/**
 * Session Bean implementation class ProjectBean
 */
@Stateless
public class ProjectBean implements IProject {
	
	@PersistenceContext(unitName="JPADB")
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public ProjectBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void saveProject(Project project) {
		entityManager.persist(project);
	}

	@Override
	public Project findProject(Project project) {
		Project p = entityManager.find(Project.class, project.getPnumber());
		return p;
	}

	@Override
	public List<Project> retrieveAllProjects() {
		String sql = "SELECT p FROM " + Project.class.getName() + " p";
		Query query = entityManager.createQuery(sql);
		List<Project> projects = query.getResultList();
		return projects;
	}

}
