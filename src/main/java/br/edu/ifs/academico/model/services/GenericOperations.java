package br.edu.ifs.academico.model.services;

import br.edu.ifs.academico.model.interfaces.IEntity;

import java.util.List;

// Essa classe está encarregada de fazer as operações que pertecem a todas as entidades
public class GenericOperations<E extends IEntity> {
// O tipo "E" obrigatoriamente deve implementar a interface Ientity (Ou seja deve ser uma entidade)

    // O atributo operationEntity armazena o tipo de entidade que está sendo
    // processada
    private final Class<E> operationEntity;
//    private EntityManager em;

    public Class<E> getOperationEntity() {
        return operationEntity;
    }

    public GenericOperations(Class<E> operationEntity /*EntityManager em*/) {
        this.operationEntity = operationEntity;
//        this.em = em;
    }

    public void register(E entity) {
//
//        em.getTransaction().begin();
//
//        em.persist(entity);
//
//        em.getTransaction().commit();

    }

    // OBS: O metodo retorna "E" que por natureza é o mesmo tipo do "E" da instancia
    // da classe
    // EX: Se GenericOperations<Visitor> então select(pk) retorna um Visitor
    public E select(Object pk) {

        // pk é do tipo Object por causa que dessa maneira ela aceita qualquer objeto
        // que seja filho de Object
        // EX: String, Integer, Character etc.

//        return em.find(operationEntity, pk);
        return null;
    }

    public void delete(Object pk) {

//        em.getTransaction().begin();
//
//        em.remove(select(pk));
//
//        em.getTransaction().commit();

    }

    public void update(E alteredEntity,E args) {

        if(alteredEntity.getKey().equals(args.getKey())) {
//
//            em.getTransaction().begin();
//
//            em.merge(args);
//
//            em.getTransaction().getClass();

        } else {



            register(args);

            delete(alteredEntity.getKey());


        }


    }

    public boolean exists(Object pk) {
//
//        return (select(pk) == null) ? false : true;
        return true;
    }

    public List<E> list() {

        String jpql = "SELECT e FROM " + operationEntity.getSimpleName() + " e";
//
//        return em.createQuery(jpql, operationEntity).getResultList();
        return null;
    }

}