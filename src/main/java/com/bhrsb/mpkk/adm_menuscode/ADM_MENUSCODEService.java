package com.bhrsb.mpkk.adm_menuscode;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//defining the business logic  
@Service
public class ADM_MENUSCODEService {

    private ADM_MENUSCODERepository bookRepository;

    public ADM_MENUSCODEService() {
    }

    @Autowired
    public ADM_MENUSCODEService(ADM_MENUSCODERepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<ADM_MENUSCODE> findAll() {
        return bookRepository.findAll();
    }

    public Optional<ADM_MENUSCODE> findById(Long id) {
        return bookRepository.findById(id);
    }

    public ADM_MENUSCODE save(ADM_MENUSCODE book) {
        bookRepository.save(book);
        return book;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public void update(ADM_MENUSCODE book) {
        bookRepository.save(book);
    }

}
