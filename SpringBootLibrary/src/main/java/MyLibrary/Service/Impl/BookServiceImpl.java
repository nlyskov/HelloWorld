package MyLibrary.Service.Impl;

import MyLibrary.Dao.BookDao;
import MyLibrary.Dao.Impl.BookDaoImpl;
import MyLibrary.Model.Book;
import MyLibrary.Service.BookService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class BookServiceImpl implements BookService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> getAllBooks() {
        return em.createQuery("select s from Book s", Book.class)
                .getResultList();
    }
}
