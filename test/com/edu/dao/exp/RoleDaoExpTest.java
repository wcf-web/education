package com.edu.dao.exp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-10 15:15
 * @Modified By:
 */
public class RoleDaoExpTest {

    @Test
    public void deleteRole() {
        System.out.println(new RoleDaoExp().deleteRole(5));
    }
}