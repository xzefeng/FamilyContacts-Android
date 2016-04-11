package com.noandroid.familycontacts.model;

import com.noandroid.familycontacts.model.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "TELEPHONE".
 */
public class Telephone {

    private Long id;
    private String number;
    private Long contactId;
    private Long cityId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient TelephoneDao myDao;

    private Contact contact;
    private Long contact__resolvedKey;

    private City city;
    private Long city__resolvedKey;


    public Telephone() {
    }

    public Telephone(Long id) {
        this.id = id;
    }

    public Telephone(Long id, String number, Long contactId, Long cityId) {
        this.id = id;
        this.number = number;
        this.contactId = contactId;
        this.cityId = cityId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTelephoneDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /** To-one relationship, resolved on first access. */
    public Contact getContact() {
        Long __key = this.contactId;
        if (contact__resolvedKey == null || !contact__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactDao targetDao = daoSession.getContactDao();
            Contact contactNew = targetDao.load(__key);
            synchronized (this) {
                contact = contactNew;
            	contact__resolvedKey = __key;
            }
        }
        return contact;
    }

    public void setContact(Contact contact) {
        synchronized (this) {
            this.contact = contact;
            contactId = contact == null ? null : contact.getId();
            contact__resolvedKey = contactId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public City getCity() {
        Long __key = this.cityId;
        if (city__resolvedKey == null || !city__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CityDao targetDao = daoSession.getCityDao();
            City cityNew = targetDao.load(__key);
            synchronized (this) {
                city = cityNew;
            	city__resolvedKey = __key;
            }
        }
        return city;
    }

    public void setCity(City city) {
        synchronized (this) {
            this.city = city;
            cityId = city == null ? null : city.getId();
            city__resolvedKey = cityId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
