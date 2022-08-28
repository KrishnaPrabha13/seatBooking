package com.srm.core.repository;

import org.springframework.stereotype.Repository;

@Repository
public class TestRepositoryImpl implements TestRepository {
    @Override
    public String get() {
        return "Test JUnit 5";
    }
}
