#ifndef __SORTING_H__
#define __SORTING_H__

#include <vector>

namespace stuff {

class Sorting {
  public:
    void insertionSort(std::vector<int> list);
    void mergeSort(std::vector<int> list, int p, int r);
    void printList(std::vector<int> list);
  private:
    std::vector<int> merge(std::vector<int> list, int p, int q, int r);
};

} // namespace stuff
#endif
