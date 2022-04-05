package my.dev.com.algoritms.search.graph.bfs.search;

import java.util.*;

public class BreadthFirstSearch {

    public static Optional<Person> findFirstPersonInContactsByHobby(List<Person> myContacts, Map<String, List<Person>> friendsOfFriendsMap, Hobby hobby) {
        //For direct contacts, the queue is created,
        // which in the search process will include
        // the contacts of a person who does not meet the search criteria
        LinkedList<Person> queueSearch = new LinkedList<>(myContacts);

        //The Set is created for person who have already been checked and do not meet the search criteria
        Set<Person> processedPerson = new HashSet<>();

        while (!queueSearch.isEmpty()) {                 // While there are people in queue to check
            Person person = queueSearch.removeFirst();   // We take the first person from the queue

            if (processedPerson.contains(person)) {      //We check if this person has already been checked
                continue;                                //(because there may be duplicates in the contacts).
            }                                            // If the check is valid - then will not check anything
            // and will return to the next person in the queue


            //If the search criteria match - we return the person
            if (person.getHobby().equals(hobby)) {
                return Optional.of(person);
            } else {
                //If not - add the person to the Set(processedPerson) of processed persons
                // and add to the queue(queueSearch) a list of his contacts
                processedPerson.add(person);
                queueSearch.addAll(friendsOfFriendsMap.getOrDefault(person.getFullName(), new ArrayList<>()));
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {

        //Mock initialize my direct contacts(friends)  (Friends' relation first level)
        List<Person> myFriends = List.of(
                new Person("Roma Gorbik", Hobby.FISHING),
                new Person("Ruslan Beheka", Hobby.SNOWBOARD),
                new Person("Taras Boychuk", Hobby.MENTORING));

        //Mock initialize direct contacts(friends) of my friends (Friends' relation second level)
        List<Person> romaFriends = List.of(
                new Person("Rita Gorbik", Hobby.EMBROIDERY),
                new Person("Maksim Pastushenko", Hobby.HUNTING),
                new Person("Matvey Matviev", Hobby.SELF_DEVELOPMENT));
        List<Person> ruslanFriends = List.of(
                new Person("Sasha Shostac", Hobby.FOOTBALL),
                new Person("Anton Chaica", Hobby.LAYING),
                new Person("Duchak Bogdan", Hobby.ATHLETICS));
        List<Person> tarasFriends = List.of(
                new Person("Andriy Kovalchuk", Hobby.TRAVEL),
                new Person("Serhii Hryhus", Hobby.PHOTO),
                new Person("Olia Boychuk", Hobby.PAINTING));

        //Mock initialize direct contacts(friends) of my friends' friends(Friends' relation third level)
        List<Person> ritaGorbikFriends = List.of(
                new Person("Alexandr Krasovsky", Hobby.WEIGHTLIFTING),
                new Person("Stas Chumak", Hobby.RACE),
                new Person("Mutalib Salmanov", Hobby.SWIMMING));
        List<Person> maksimPastushenkoFriends = List.of(
                new Person("Robert Nesta Marley", Hobby.SKIING),
                new Person("Viktor Veselskyi", Hobby.HUNTING),
                new Person("Valera Sherbina", Hobby.SELF_DEVELOPMENT));
        List<Person> matveyMatvievFriends = List.of(
                new Person("Roman Vlasenko", Hobby.TRAVEL),
                new Person("Viktor Veselskyi", Hobby.PHOTO),
                new Person("Nikitos Gudzenko", Hobby.PAINTING));
        List<Person> shostacSashaFriends = List.of(
                new Person("Leonid Lutvunenko", Hobby.FOOTBALL),
                new Person("Vadim Vovkovinskiy", Hobby.LAYING),
                new Person("Roman Cholovskiy", Hobby.ATHLETICS));
        List<Person> antonChaicaFriends = List.of(
                new Person("Oleg Anatolievich", Hobby.WEIGHTLIFTING),
                new Person("Andrew Bryn", Hobby.RACE),
                new Person("Roman Grytsan", Hobby.SWIMMING));
        List<Person> duchakBogdanFriends = List.of(
                new Person("Andrew Vlasenko", Hobby.SKIING),
                new Person("Viktor Lutvunenko", Hobby.HUNTING),
                new Person("Nikitos Chumak", Hobby.SELF_DEVELOPMENT));
        List<Person> andriyKovalchukFriends = List.of(
                new Person("Alexandr Chaica", Hobby.TRAVEL),
                new Person("Ruslan Salmanov", Hobby.PHOTO),
                new Person("Roman Cholovskiy", Hobby.PAINTING));
        List<Person> serhiiHryhusFriends = List.of(
                new Person("Oleg Vlasenko", Hobby.WEIGHTLIFTING),
                new Person("Roman Gudzenko", Hobby.RACE),
                new Person("Roman Sherbina", Hobby.SWIMMING));
        List<Person> oliaBoychukFriends = List.of(
                new Person("Andrew Marley", Hobby.FOOTBALL),
                new Person("Viktor Bryn", Hobby.LAYING),
                new Person("Olia Chumak", Hobby.ATHLETICS));
        //end end etc...


        //Mock relation contacts first and second levels
        Map<String, List<Person>> friendsOfFriends = new HashMap<>();
        friendsOfFriends.put("Roma Gorbik", romaFriends);
        friendsOfFriends.put("Ruslan Beheka", ruslanFriends);
        friendsOfFriends.put("Taras Boychuk", tarasFriends);
        friendsOfFriends.put("Rita Gorbik", ritaGorbikFriends);
        friendsOfFriends.put("Maksim Pastushenko", maksimPastushenkoFriends);
        friendsOfFriends.put("Matvey Matviev", matveyMatvievFriends);
        friendsOfFriends.put("Shostac Sasha", shostacSashaFriends);
        friendsOfFriends.put("Anton Chaica", antonChaicaFriends);
        friendsOfFriends.put("Duchak Bogdan", duchakBogdanFriends);
        friendsOfFriends.put("Andriy Kovalchuk", andriyKovalchukFriends);
        friendsOfFriends.put("Serhii Hryhus", serhiiHryhusFriends);
        friendsOfFriends.put("Olia Boychuk", oliaBoychukFriends);


        Person searchResult = findFirstPersonInContactsByHobby(myFriends, friendsOfFriends, Hobby.TRAVEL)
                .orElseThrow(() -> new NotFoundPerson("Can't find person with input hobby!"));
        System.out.println("Name: " + searchResult.getFullName());

    }
}
