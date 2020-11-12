package data.service;

import java.util.Collections;
import java.util.TreeSet;

/**
 * @author Created by Miguel Gutierrez on 11.11.2020
 * @since 1.11
 */
public interface ServiceI<T>extends General_I<T> {

    T getOne(int id);
    TreeSet<T> getAll();
}
