package ca.sfu.cmpt745.ex02;

import java.util.*;
import java.util.stream.Collectors;


public final class OperationRunner {

  OperationRunner(ArrayList<Operation> operations) {
    this.operations = new ArrayList<Operation>(operations);
    for (Operation operation : this.operations) {
      events.computeIfAbsent(operation.getClass().getName(), k -> new ArrayList<>()).add(operation);
    }
  }
  final ArrayList<Operation> operations;
  final  Map<String, List<Operation>> events = new HashMap<>();

  public final void run() {



    for(Map.Entry<String, List<Operation>> e: events.entrySet()){
      for (Operation op : e.getValue()) {
        op.run();
      }
    }
  }


}

