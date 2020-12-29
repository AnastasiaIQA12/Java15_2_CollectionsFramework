package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Application;
import ru.netology.domain.FileExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    FileOpenManager manager = new FileOpenManager();
    FileExtension fileExtension1 = new FileExtension("HTML");
    FileExtension fileExtension2 = new FileExtension("jpeg");
    FileExtension fileExtension3 = new FileExtension("txt");
    Set<Application> applicationInternet = new HashSet<>();
    Application application1 = new Application("Google");
    Application application2 = new Application("Mozilla");
    Application application3 = new Application("Safari");
    Set<Application> applicationPhoto = new HashSet<>();
    Application application4 = new Application("AdobePhotoshop");
    Application application5 = new Application("Paint");
    Application application6 = new Application("Фотографии");
    Set<Application> applicationText = new HashSet<>();
    Application application7 = new Application("Блокнот");
    Application application8 = new Application("MSWord");
    Application application9 = new Application("WordPad");

    @BeforeEach
    public void setUp() {
        applicationInternet.add(application1);
        applicationInternet.add(application2);
        applicationInternet.add(application3);
        applicationPhoto.add(application4);
        applicationPhoto.add(application5);
        applicationPhoto.add(application6);
        applicationText.add(application7);
        applicationText.add(application8);
        applicationText.add(application9);
        manager.addApp(fileExtension1, applicationInternet);
        manager.addApp(fileExtension2, applicationPhoto);
        manager.addApp(fileExtension3, applicationText);
    }

    @Test
    void shouldAddApplication() {
        Map<FileExtension, Set<Application>> actual = manager.getAll();
        Map<FileExtension, Set<Application>> expected = new HashMap<>();
        expected.put(new FileExtension("html"), applicationInternet);
        expected.put(fileExtension2, applicationPhoto);
        expected.put(fileExtension3, applicationText);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAppByExtension() {
        Set<Application> actual = manager.findApp(fileExtension1);
        Set<Application> expected = new HashSet<>();
        expected.add(application1);
        expected.add(application2);
        expected.add(application3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveAppBinding() {
        manager.removeAppBinding(fileExtension1);
        Map<FileExtension, Set<Application>> actual = manager.getAll();
        Map<FileExtension, Set<Application>> expected = new HashMap<>();
        expected.put(fileExtension2, applicationPhoto);
        expected.put(fileExtension3, applicationText);
        assertEquals(expected, actual);
    }

    @Test
    void shouldListAllExtension() {
        Map<FileExtension, Set<Application>> file = manager.getAll();
        List<FileExtension> actual = manager.listAllExtension(file);
        List<FileExtension> expected = new ArrayList<>();
        expected.add(fileExtension1);
        expected.add(fileExtension2);
        expected.add(fileExtension3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldListAllApplication() {
        Map<FileExtension, Set<Application>> file = manager.getAll();
        List<Application> actual = manager.listAllApp(file);
        List<Application> expected = new ArrayList<>();
        expected.add(application4);
        expected.add(application1);
        expected.add(application8);
        expected.add(application2);
        expected.add(application5);
        expected.add(application3);
        expected.add(application9);
        expected.add(application7);
        expected.add(application6);
        assertEquals(expected, actual);
    }
}