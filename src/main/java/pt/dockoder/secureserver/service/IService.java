package pt.dockoder.secureserver.service;

import java.util.Optional;

public interface IService<T> {

    <S extends T> S save(S var1);

    <S extends T> Iterable<S> saveAll(Iterable<S> var1);

    Optional<T> findById(Long var1);

    boolean existsById(Long var1);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<Long> var1);

    long count();

    void deleteById(Long var1);

    void delete(T var1);

    void deleteAll(Iterable<? extends T> var1);

    void deleteAll();

    public String login(String username, String password);

    public Optional findByToken(String token) ;
}
