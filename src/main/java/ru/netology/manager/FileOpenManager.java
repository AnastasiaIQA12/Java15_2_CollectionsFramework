package ru.netology.manager;

import ru.netology.domain.Application;
import ru.netology.domain.FileExtension;

import java.util.*;

public class FileOpenManager {
    Map<FileExtension, Set<Application>> file = new HashMap<>();


    public Set<Application> addApp(FileExtension fileExtension, Set<Application> application) {
        String extention = fileExtension.getExtensionFile().toLowerCase();
        fileExtension.setExtensionFile(extention);
        return file.put(fileExtension, application);
    }

    public Map<FileExtension, Set<Application>> getAll() {
        return file;
    }

    public Set<Application> findApp(FileExtension fileExtension) {
        return file.get(fileExtension);
    }

    public Set<Application> removeAppBinding(FileExtension fileExtension) {
        return file.remove(fileExtension);
    }

    public List<FileExtension> listAllExtension(Map<FileExtension, Set<Application>> file) {
        Set<FileExtension> listExtension = file.keySet();
        List<FileExtension> extension = new ArrayList<>(listExtension);
        Collections.sort(extension);
        return extension;
    }

    public List<Application> listAllApp(Map<FileExtension, Set<Application>> file) {
        Collection<Set<Application>> listApplication = file.values();
        List<Application> ListApp = new ArrayList<>();
        for (Set<Application> application : listApplication) {
            ListApp.addAll(application);
        }
        Collections.sort(ListApp);
        return ListApp;
    }
}
