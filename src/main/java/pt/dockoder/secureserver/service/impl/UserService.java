package pt.dockoder.secureserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.dockoder.secureserver.domain.users.User;
import pt.dockoder.secureserver.repository.UserRepository;
import pt.dockoder.secureserver.service.IService;

import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IService<User> {

    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public String login(String username, String password) {
        Optional<User> user = repo.login(username, password);
        if(user.isPresent()){
            String token = UUID.randomUUID().toString();
            User u = user.get();
            u.setToken(token);
            repo.save(u);
            return token;
        }
        return "";
    }

    @Override
    public Optional findByToken(String token) {
        Optional<User> user = repo.findByToken(token);
        if(user.isPresent()){
            User u = user.get();
            User us = new User(u.getFirstName(), u.getLastName(), u.getEmails());
        }
        return Optional.empty();
    }

    @Override
    public <S extends User> S save(S var1) {
        return repo.save(var1);
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> var1) {
        return repo.saveAll(var1);
    }

    @Override
    public Optional<User> findById(Long var1) {
        return repo.findById(var1);
    }

    @Override
    public boolean existsById(Long var1) {
        return repo.existsById( var1);
    }

    @Override
    public Iterable<User> findAll() {
        return repo.findAll();
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> var1) {
        return repo.findAll();
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public void deleteById(Long var1) {
        repo.deleteById(var1);
    }

    @Override
    public void delete(User var1) {
        repo.delete(var1);
    }

    @Override
    public void deleteAll(Iterable<? extends User> var1) {
        repo.deleteAll(var1);
    }

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }

    public boolean findByNif(String nif){

        if (nif.isEmpty() || "".equals(nif))
            return false;

        Iterator<User> it = repo.findAll().iterator();

        while (it.hasNext())
             if (it.next().getFiscalNumber().equals(nif))
                 return true;

        return false;
    }
}
