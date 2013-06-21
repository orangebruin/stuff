#include <vector>

#include "sorting.h"

int main() {
  std::vector<int> list;
  list.push_back(4);
  list.push_back(6);
  list.push_back(132);
  list.push_back(56);
  list.push_back(11);
  list.push_back(43);
  list.push_back(37);
  list.push_back(1);
  list.push_back(3);
  list.push_back(7);

  stuff::Sorting sort;
//  sort.insertionSort(list);
  sort.printList(list);
  sort.mergeSort(list, 0, list.size());
}
