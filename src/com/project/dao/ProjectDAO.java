package com.project.dao;

import com.project.model.Projekt;

import java.util.List;

public interface ProjectDAO {

    List<Projekt> get();

    Projekt get(int id);

    boolean save(Projekt projekt);

    boolean delete(int id);

    boolean update(Projekt projekt);
}
