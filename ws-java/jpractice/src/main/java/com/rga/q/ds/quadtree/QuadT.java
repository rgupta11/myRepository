package com.rga.q.ds.quadtree;
import com.rga.q.ds.treeutils.Node;

/*  QuadTree in-memory Tree to manage LBS geospatial indexes
 *  Divides business area into four quadrants or regions until
 *  each region contains a single data point or is empty.
 */
public class QuadT {


    public void buildQuadTree(Node root) {
        if (bizCountInCurrentGrid(root) > 100){
            root.subDivide();
            for (Node child : root.getChildren()) {
                buildQuadTree(child);
            }
        }
    }

    public int bizCountInCurrentGrid(Node node) {
        // Implementation for counting business entities in the current grid
        return 0;
    }
    

}
