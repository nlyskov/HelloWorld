package MyLibrary.Dao.Impl;

import MyLibrary.Dao.BookDao;
import MyLibrary.Model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Transactional
@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> getAllBooks() {
        return em.createQuery("select s from Book s", Book.class)
                .getResultList();
    }
}
