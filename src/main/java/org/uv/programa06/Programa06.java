/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa06;

import org.hibernate.Session;

/**
 *
 * @author wbpat
 */
public class Programa06 {

    public static void main(String[] args) {
        Session s = HibernateUtil.getSession();
        System.out.println("Hello World!");
    }
}
