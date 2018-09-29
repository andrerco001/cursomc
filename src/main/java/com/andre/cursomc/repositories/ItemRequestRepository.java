package com.andre.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.cursomc.domain.ItemRequest;;

@Repository
public interface ItemRequestRepository extends JpaRepository<ItemRequest, Integer>
{
	

}
