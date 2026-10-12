package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import tn.esprit.autoloc.domain.Client;

public interface ClientRepository extends CrudRepository<Client,Long> { }

// public interface ClientRepository extends JpaRepository<Client,Long> { }

// public interface ClientRepository extends PagingAndSortingRepository<Client,Long> { }
