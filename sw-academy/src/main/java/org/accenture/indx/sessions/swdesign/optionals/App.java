package org.accenture.indx.sessions.swdesign.optionals;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

public class App {

    /**
     *
     *                                 Notes
     *
     * Rule 1: Never, ever, use null for an optional variable or return value
     * Rule 2: Never use Optional.get() unless you can prove that the optional is present.
     *         - No isPresent() before get() please! There are alternatives and exceptions, of course.
     *         Brian Goetz wrote in stackOverFlow:
     *      *              Public service announcement: NEVER call Optional.get() unless you can prove it will never be null; instead use one of the safe methods like orElse or ifPresent.
     *      *              In retrospect, we should have called get something like getOrElseThrowNoSuchElementException
     *      *              or something that made it far clearer that this was a highly dangerous method that undermined the whole purpose of Optional in the first place.
     *      *              Lesson learned. (UPDATE: Java 10 has Optional.orElseThrow(), which is semantically equivalent to get(), but whose name is more appropriate.)
     * Rule 3: Optional<Optional<T>> is mostly too complex. Avoid it!
     * Rule 4: Avoid using Optional in fields, method parameters, and collections. Optional usage is more appropriate for client side where the object can be null due to some reasons.
     * Rule 5: Remember Optional is a box and a separate object - which means it consumes 4x memory of a bare reference. Potentially adds GC pressure.
     *
     * https://blog.joda.org/2015/08/java-se-8-optional-pragmatic-approach.html
     *
     *
     */

    public static void main(String[] args) {
        //Case:1
        // isPresent(), get(),   ifPresent(),

        var filteredUser = getUsers()
                .stream()
                .filter(user -> user.getId() == 1 )
                .findFirst();

        //Bad
        System.out.println(filteredUser.isPresent() ? filteredUser.get() : "Oops..");
        //Bad
        if(filteredUser.isPresent()) System.out.println(filteredUser.get());
        else System.out.println("Oops.");

        //Good - ifPresent -> do something
        filteredUser.ifPresent(System.out::println);
        //Good - use map operation of optional and care what happens when value not found
        System.out.println(filteredUser.map(User::getEmail).orElse("Oops"));

        //Case: 2 - or(supplier), ifPresentOrElse(Consumer, Runnable)
        var filteredUser2 = getUsers()
                .stream()
                .filter(user -> user.getId() == 1)
                .findFirst()
                //If nothing found, creating a new filteredUser on demand
                .or(() -> createUser(1, "temp123@vodefone.com"));

        filteredUser2.map(User::getEmail).ifPresentOrElse(System.out::println, () -> System.out.println("do something else..."));

        //Case: 3 - orElse() Danger
        var filteredUser3 = getUsers()
                .stream()
                //TODO: Switch Id from 1 to 3 to get an email address and check again.
                .filter(user -> user.getId() == 1)
                .findFirst()
                .map(User::getEmail)
                .orElse(runIfEmpty());
//                .orElseGet(App::runIfEmpty);
        System.out.println(filteredUser3);


    }

    static String runIfEmpty(){
        System.out.println("Running becuase it is empty...");
        return "Empty";
    }

    static Optional<User> createUser(int height, String email) {
        return Optional.of(new User(height, email));
    }

    static List<User> getUsers() {
        return List.of(
                new User(1),
                new User(2),
                new User(3, "user3@accenture.com"),
                new User(4, "user4@accenture.com"));
    }

    @Getter
    @ToString
    static class User {
        int id;
        String email;

        public User(int id) {
            this.id = id;
        }

        public User(int id, String email) {
            this.id = id;
            this.email = email;
        }

    }
}
