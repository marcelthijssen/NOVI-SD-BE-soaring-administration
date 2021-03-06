/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Extends JpaRepository and communicates with database column 'planes'
 *
 */

package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long > {
}
