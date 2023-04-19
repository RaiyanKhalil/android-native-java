package com.example.final_practise_one;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SchoolDB extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "SchoolDB";
    final static int DATABASE_VERSION = 2;

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE StudentsTable ("
            + "Id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT,"
            + "email TEXT,"
            + "phone TEXT,"
            + "birthdate TEXT,"
            + "password TEXT)";

    private static final String CREATE_TABLE_BOOKS = "CREATE TABLE BooksTable ("
            + "book_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "title TEXT,"
            + "author TEXT)";

    private static final String CREATE_TABLE_GRADES = "CREATE TABLE GradesTable ("
            + "student_id INTEGER,"
            + "course_id INTEGER,"
            + "marks INTEGER,"
            + "PRIMARY KEY(student_id, course_id),"
            + "FOREIGN KEY(student_id) REFERENCES StudentsTable(Id),"
            + "FOREIGN KEY(course_id) REFERENCES CoursesTable(course_id))";

    private static final String CREATE_TABLE_COURSES = "CREATE TABLE CoursesTable ("
            + "course_id TEXT PRIMARY KEY,"
            + "course_name TEXT)";

    public SchoolDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
        db.execSQL(CREATE_TABLE_BOOKS);
        db.execSQL(CREATE_TABLE_GRADES);
        db.execSQL(CREATE_TABLE_COURSES);
        // Insert data into CoursesTable
        db.execSQL("INSERT INTO CoursesTable (course_id, course_name) " +
                "VALUES ('CSIS3175', 'Introduction to Mobile Development')");
        db.execSQL("INSERT INTO CoursesTable (course_id, course_name) " +
                "VALUES ('CSIS3275', 'Introduction to PHP')");
        db.execSQL("INSERT INTO CoursesTable (course_id, course_name) " +
                "VALUES ('CSIS4270', 'Cloud Computing')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS StudentsTable");
        db.execSQL("DROP TABLE IF EXISTS BooksTable");
        db.execSQL("DROP TABLE IF EXISTS GradesTable");
        db.execSQL("DROP TABLE IF EXISTS CoursesTable");
        onCreate(db);
    }

    public boolean addStudentData(String name, String email,
                                  String phone, String birthdate,
                                  String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("phone", phone);
        values.put("birthdate", birthdate);
        values.put("password", password);

        long l = sqLiteDatabase.insert("StudentsTable",
                null,values);
        if(l > 0)
            return true;
        else
            return false;
    }

    public boolean addBookData(String title, String author){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("author", author);
        long l = sqLiteDatabase.insert("BooksTable",
                null,values);
        if(l > 0)
            return true;
        else
            return false;
    }

    public boolean addGrade(Integer student_Id,
                            String course_Id, String grade){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("student_id", student_Id);
            values.put("course_id", course_Id);
            values.put("marks", grade);
            long l = sqLiteDatabase.insert("GradesTable",
                    null,values);
            if(l > 0)
                return true;
            else
                return false;
    }
    public Cursor getBookList(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + "BooksTable";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor;
    }

    public Cursor getInnerJoin(Integer student_id){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM StudentsTable " +
                "INNER JOIN GradesTable " +
                "ON StudentsTable.id = GradesTable.student_id " +
                "WHERE StudentsTable.id = ?";
        String[] args = { String.valueOf(student_id) };
        Cursor cursor = sqLiteDatabase.rawQuery(query, args);
        return cursor;
    }

    public Cursor loginUser(Integer studentID,
                            String studentPass){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + "StudentsTable" +
                " WHERE " + "Id" + "=" + '"' + studentID + '"' + " AND " +
                "password" + "=" + '"' + studentPass + '"';
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        return cursor;
    }
}
