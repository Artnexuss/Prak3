package com.example.task3.service;

import com.example.task3.model.user;
import com.example.task3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Метод с демонстрацией всех операций
    public void runDemo() {
        System.out.println("=== Демонстрация работы JPA Repository ===");

        // 1. Создание объектов
        user user1 = new user("Иван Иванов", "ivan@example.com", LocalDate.now());
        user user2 = new user("Мария Петрова", "maria@example.com", LocalDate.now().minusDays(1));

        System.out.println("Созданные объекты:");
        System.out.println(user1);
        System.out.println(user2);

        // 2. Сохранение в БД
        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
        System.out.println("\nСохранены в БД. ID user1 = " + user1.getId());

        // 3. Получить всех
        System.out.println("\nВсе пользователи в БД:");
        userRepository.findAll().forEach(System.out::println);

        // 4. Редактирование
        user1.setName("Иван Иванович (отредактировано)");
        user1 = userRepository.save(user1);
        System.out.println("\nПосле редактирования:");
        System.out.println(user1);

        // 5. Получить по ID
        userRepository.findById(user1.getId()).ifPresent(u ->
                System.out.println("\nНайден по ID: " + u));

        // 6. Удаление
        userRepository.deleteById(user2.getId());
        System.out.println("\nПользователь user2 удалён.");

        // 7. Проверка после удаления
        System.out.println("\nВсе пользователи после удаления:");
        userRepository.findAll().forEach(System.out::println);

        System.out.println("\n=== Демонстрация завершена ===");
    }
}