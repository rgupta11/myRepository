package com.rga.q.ds.quadtree;
import com.rga.q.ds.tree.treeutils.Node;

/*  QuadTree in-memory Tree to manage LBS geospatial indexes
 *  Divides business area into four quadrants or regions until
 *  each region contains a single data point or is empty.
 */
public class QuadT {


    public void buildQuadTree(Cache root) {
        if (bizCountInCurrentGrid(root) > 100){
            root.subDivide();
            for (Cache child : root.getChildren()) {
                buildQuadTree(child);
            }
        }
    }

    public int bizCountInCurrentGrid(Cache node) {
        // Implementation for counting business entities in the current grid
        return 0;
    }
    

}
