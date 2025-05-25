package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Objects;

public class StudentDaoImpl implements GenericDao<Student, Long> {

    private EntityManagerFactory emf;

    public StudentDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(final Student student) {
        Objects.requireNonNull(student, "Parameter [student] must not be null!");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            if (student.getId() == null) {
                entityManager.persist(student);
            } else {
                entityManager.merge(student);
            }
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new RuntimeException("Cannot save student " + student, ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Student findById(Long id) {
        return emf.createEntityManager().find(Student.class, id);
    }

    @Override
    public Student findByEmail(String email) {
        return emf.createEntityManager()
                .createQuery("FROM Student s WHERE s.email = :email", Student.class)
                .setParameter("email", Objects.requireNonNull(email))
                .getSingleResult();
    }

    @Override
    public List<Student> findAll() {
        return emf.createEntityManager()
                .createQuery("FROM Student", Student.class)
                .getResultList();
    }

    @Override
    public Student update(Student student) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Student updatedStudent = entityManager.merge(student);
            transaction.commit();
            return updatedStudent;
        } catch (Exception ex) {
            transaction.rollback();
            throw new RuntimeException("Cannot update student data " + student, ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deleteById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Student student = entityManager.find(Student.class, id);
            if (student != null) {
                entityManager.remove(student);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception ex) {
            transaction.rollback();
            throw new RuntimeException("Cannot delete student with ID " + id, ex);
        } finally {
            entityManager.close();
        }
    }
}



