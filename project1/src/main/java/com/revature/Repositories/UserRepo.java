package com.revature.Repositories;

import com.revature.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByEmailAndPassword(String email, String password);

    /* Stretch Goal: Useful functions for admins to get user by creation and updated times

    // Retrieves a user by a specific time it was created at
    public User findByCreated_at(LocalDate localDateTime);

    // Retrieves a user by a specific time it was updated at
    public User findByUpdated_at(LocalDate localDateTime);

    // Retrieves all users created at a specific month
    public List<User> findUsersByCreated_at(Month month);
     */
}
