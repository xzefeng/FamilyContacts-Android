package com.noandroid.familycontacts.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.noandroid.familycontacts.model.Blacklist;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BLACKLIST".
*/
public class BlacklistDao extends AbstractDao<Blacklist, Long> {

    public static final String TABLENAME = "BLACKLIST";

    /**
     * Properties of entity Blacklist.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property PhoneNumber = new Property(1, String.class, "PhoneNumber", false, "PHONE_NUMBER");
    };


    public BlacklistDao(DaoConfig config) {
        super(config);
    }
    
    public BlacklistDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BLACKLIST\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"PHONE_NUMBER\" TEXT);"); // 1: PhoneNumber
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_BLACKLIST_PHONE_NUMBER ON BLACKLIST" +
                " (\"PHONE_NUMBER\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BLACKLIST\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Blacklist entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String PhoneNumber = entity.getPhoneNumber();
        if (PhoneNumber != null) {
            stmt.bindString(2, PhoneNumber);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Blacklist readEntity(Cursor cursor, int offset) {
        Blacklist entity = new Blacklist( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // PhoneNumber
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Blacklist entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPhoneNumber(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Blacklist entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Blacklist entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}