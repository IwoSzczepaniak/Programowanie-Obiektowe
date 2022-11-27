package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection [] animalMoves;
    private final IWorldMap mapInstance;
    private final ArrayList<Animal> Creatures = new ArrayList<>();

    public SimulationEngine( MoveDirection [] animalMoves, IWorldMap mapInstance, Vector2d [] animalBegPositions){
        this.mapInstance = mapInstance;
        this.animalMoves = animalMoves;

        for(Vector2d curr: animalBegPositions){
            Animal ani = new Animal(mapInstance, curr);
            if(mapInstance.place(ani)) Creatures.add(ani);
            else throw new IllegalArgumentException(curr + " some creature is already in this place");
        }
    }


    public SimulationEngine(IWorldMap mapInstance){
        this.mapInstance = mapInstance;
    }

    public SimulationEngine( IWorldMap mapInstance, Vector2d [] animalBegPositions){
        this.mapInstance = mapInstance;
        for(Vector2d curr: animalBegPositions){
            Animal ani = new Animal(mapInstance, curr);
            if(mapInstance.place(ani)) Creatures.add(ani);
            else throw new IllegalArgumentException(curr + " some creature is already in this place");
        }
    }
    public void setMoveDirection(MoveDirection[] animalMoves){
        this.animalMoves = animalMoves;
    }



    public void run(){
        System.out.println("Thread started");
        int i = 0;
        for(MoveDirection order: animalMoves){
            try{
                Thread.sleep(300);
            }catch(InterruptedException ex){
                System.out.println(ex);
            }
            Creatures.get(i).move(order);
            i ++;
            if (i == Creatures.size()) i = 0;


            System.out.println(mapInstance); //trzeba będzie kom
        }
    }

    public ArrayList<Animal> getCreatures(){
        return Creatures;
    }
}
