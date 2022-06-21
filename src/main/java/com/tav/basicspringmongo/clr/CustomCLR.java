package com.tav.basicspringmongo.clr;

import com.tav.basicspringmongo.entities.Event;
import com.tav.basicspringmongo.entities.User;
import com.tav.basicspringmongo.repository.EventRepository;
import com.tav.basicspringmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomCLR implements CommandLineRunner {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;


    @Override
    public void run(String... args) throws Exception {

        final String userId = UUID.randomUUID().toString();

        final User user = User.builder()
                .id(userId)
                .email("tav@gmail.com")
                .password("1234")
                .events(new ArrayList<>())
                .build();

        userRepository.save(user);

        final Event event = Event.builder()
                .id(UUID.randomUUID().toString())
                .title("DevGeekWeek")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();

        eventRepository.save(event);

        final User fetchedUser = userRepository.findById(userId).orElse(null);
        final List<Event> userEvents = fetchedUser.getEvents();
        userEvents.add(event);
        userRepository.save(fetchedUser);
    }
}
