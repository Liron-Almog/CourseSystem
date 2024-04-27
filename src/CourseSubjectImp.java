//class CourseSubjectImp implements CourseSubject {
//    private static CourseSubjectImp instance;
//    private List<CourseObserver> observers = new ArrayList<>();
//
//    private CourseSubjectImp() {
//        // Private constructor to prevent instantiation
//    }
//
//    // Singleton getInstance() method
//    public static CourseSubjectImp getInstance() {
//        if (instance == null) {
//            instance = new CourseSubjectImp();
//        }
//        return instance;
//    }
//
//    @Override
//    public void addObserver(CourseObserver observer) {
//        observers.add(observer);
//    }
//
//    @Override
//    public void removeObserver(CourseObserver observer) {
//        observers.remove(observer);
//    }
//
//    @Override
//    public void notifyObservers(String message) {
//        for (CourseObserver observer : observers) {
//            observer.update(message);
//        }
//    }
//
//    // Method to send a new message to all observers
//    public void sendMessage(String message) {
//        notifyObservers(message);
//    }
//}