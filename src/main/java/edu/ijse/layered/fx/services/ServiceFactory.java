package edu.ijse.layered.fx.services;

import edu.ijse.layered.fx.services.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceTypes type){
        switch (type) {
            case STUDENT:
                return new StudentServiceImpl();
            case LECTURE:
                return new LecturerServiceImpl();
            case COURSE:
                return new CourseServiceImpl();
            case CLASSES:
                return new ClassServiceImpl();
            case SUBJECT:
                return new SubjectServiceImpl();
            case ENROLL:
                return new EnrollServiceImpl();
            case ATTENDANCE:
                return new AttendanceServiceImpl();
            default:
                throw new AssertionError();
        }
    }

    public enum ServiceTypes{
        STUDENT,LECTURE,COURSE,CLASSES,SUBJECT,ENROLL,ATTENDANCE;
    }
}

