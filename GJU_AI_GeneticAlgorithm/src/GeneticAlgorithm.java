import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GeneticAlgorithm {
   
   private int PopulationSize = 4;
   private int MaxGenerations = 50;
   private double MutationProbability = 0.01;
   private double CrossoverProbebaility = 0.7;
   private Random r = new Random();
   private CNF cnf = null;
   
   public GeneticAlgorithm() {
      // Read Input
      try {
         setCnf(InputReader.readInputFile("def.txt"));
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public void learn() throws Exception {
      Generation generation = new Generation();
      
      // Step #1: Create Chromosomes with randomized Genes
      for (int i = 0; i < getPopulationSize(); i++) {
         Chromosome chr = new Chromosome(cnf.getLength(), this);
         // Step #2: Caculate Fitness of each chromosome
         generation.addChromosome(chr);
      }      
      
      
      RouletteWheelSelection pairSelection = new RouletteWheelSelection(generation, getRandom(), this);
      
      List<Pair<Chromosome, Chromosome>> listPairs = pairSelection.getPairs();
      
      System.out.println(listPairs.size());
      
   }
   
   private boolean hlpChoose(double dProbability){
      return r.nextDouble() <= dProbability;
   }

   public int getPopulationSize() {
      return PopulationSize;
   }

   public void setPopulationSize(int populationSize) {
      PopulationSize = populationSize;
   }

   public int getMaxGenerations() {
      return MaxGenerations;
   }

   public void setMaxGenerations(int maxGenerations) {
      MaxGenerations = maxGenerations;
   }

   public double getMutationProbability() {
      return MutationProbability;
   }

   public void setMutationProbability(double mutationProbability) {
      MutationProbability = mutationProbability;
   }

   public double getCrossoverProbebaility() {
      return CrossoverProbebaility;
   }

   public void setCrossoverProbebaility(double crossoverProbebaility) {
      CrossoverProbebaility = crossoverProbebaility;
   }

   public Random getRandom() {
      return r;
   }

   public void setR(Random r) {
      this.r = r;
   }

   public CNF getCnf() {
      return cnf;
   }

   public void setCnf(CNF cnf) {
      this.cnf = cnf;
   }

   
   
}
