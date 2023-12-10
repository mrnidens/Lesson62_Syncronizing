package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable{
    private static Object monitor = new Object();
    private static Object monitor2 = new Object();
    private int nRaces;
    private int capacity;
    private Elevator elevator;
    private Elevator elevator2;

    public Truck(int nRaces, int capacity, Elevator elevator, Elevator elevator2) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
        this.elevator2 = elevator2;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor) {
                elevator.add(capacity/2);
            }
            synchronized (monitor2) {
                elevator2.add(capacity/2);
            }
        }
    }
}
