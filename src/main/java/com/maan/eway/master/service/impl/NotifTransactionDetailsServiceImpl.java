/*
*  Copyright (c) 2019. All right reserved
* Created on 2023-01-11 ( Date ISO 2023-01-11 - Time 13:27:46 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.maan.eway.repository.NotifTransactionDetailsRepository;
import com.maan.eway.bean.NotifTransactionDetails;
import com.maan.eway.master.service.NotifTransactionDetailsService;

import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
* <h2>NotifTransactionDetailsServiceimpl</h2>
*/
@Service
@Transactional
public class NotifTransactionDetailsServiceImpl implements NotifTransactionDetailsService {

@Autowired
private NotifTransactionDetailsRepository repository;


private Logger log=LogManager.getLogger(NotifTransactionDetailsServiceImpl.class);
/*
public NotifTransactionDetailsServiceImpl(NotifTransactionDetailsRepository repo) {
this.repository = repo;
}

  */
 @Override
    public NotifTransactionDetails create(NotifTransactionDetails d) {

       NotifTransactionDetails entity;

        try {
            entity = repository.save(d);

        } catch (Exception ex) {
			log.error(ex);
            return null;
        }
        return entity;
    }

    
    @Override
    public NotifTransactionDetails update(NotifTransactionDetails d) {
        NotifTransactionDetails c;

        try {
            c = repository.saveAndFlush(d);

        } catch (Exception ex) {
			log.error(ex);
            return null;
        }
        return c;
    }

/*
    @Override
    public NotifTransactionDetails getOne(long id) {
        NotifTransactionDetails t;

        try {
            t = repository.findById(id).orElse(null);

        } catch (Exception ex) {
			log.error(ex);
            return null;
        }
        return t;
    }

*/
    @Override
    public List<NotifTransactionDetails> getAll() {
        List<NotifTransactionDetails> lst;

        try {
            lst = repository.findAll();

        } catch (Exception ex) {
			log.error(ex);
            return Collections.emptyList();
        }
        return lst;
    }


    @Override
    public long getTotal() {
        long total;

        try {
            total = repository.count();
        } catch (Exception ex) {
            log.error(ex);
			return 0;
        }
        return total;
    }

/*
    @Override
    public boolean delete(long id) {
        try {
            repository.deleteById(id);
            return true;

        } catch (Exception ex) {
			log.error(ex);
            return false;
        }
    }

 */

}
