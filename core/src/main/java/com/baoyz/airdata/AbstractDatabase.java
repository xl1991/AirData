/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 baoyongzhang <baoyz94@gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.baoyz.airdata;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * AirData
 * Created by baoyz on 15/6/28.
 */
public abstract class AbstractDatabase {

    AirDatabaseHelper mDatabaseHelper;
    private Context mContext;

    public AbstractDatabase(Context context) {
        if (!(context instanceof Application)) {
            // TODO throw exception
        }
        mContext = context;
        mDatabaseHelper = new AirDatabaseHelperImpl(mContext, this);
    }

    public SQLiteDatabase getDatabase() {
        return mDatabaseHelper.getDatabase();
    }

    public String getName() {
        return null;
    }

    public int getVersion() {
        return 1;
    }

    public <T> List<T> query(Class<T> clazz) {
        return mDatabaseHelper.queryAll(clazz);
    }

    public long save(Object obj) {
        return mDatabaseHelper.save(obj);
    }

    public long delete(Object obj) {
        return mDatabaseHelper.delete(obj);
    }

    public long update(Object obj) {
        return mDatabaseHelper.update(obj);
    }

    public void beginTransaction(){
        mDatabaseHelper.getDatabase().beginTransaction();
    }

    public void endTransaction(){
        mDatabaseHelper.getDatabase().endTransaction();
    }

    public void setTransactionSuccessful(){
        mDatabaseHelper.getDatabase().setTransactionSuccessful();
    }

    public AirDatabaseHelper getDatabaseHelper() {
        return mDatabaseHelper;
    }
}
