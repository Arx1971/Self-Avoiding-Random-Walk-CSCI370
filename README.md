<h2>Introduction</h2>
<ul>
    <li>This project involves self-avoiding random walks (commonly called “SAW”).</li>
    <li>A self-avoiding random walk is not allowed to intersect itself.</li>
    <li>To explain, consider a two-dimensional integer grid
        <ol>
            <li>The random walk begins at the origin (0, 0).</li>
            <li>At each increment, the walk takes a step horizontally ±1 unit else vertically ±1 unit</li>
            <li>Diagonal steps are not allowed: each step is either horizontal else vertical.</li>
            <li>Suppose that after n steps, the path of the random walk is given by the set of points
                {(x0, y0),(x1, y1), . . . ,(xn, yn)}, where (x0, y0) = (0, 0).</li>
            <li>At the next step, the random walk goes to the point (xn+1, yn+1), which is one of the
                 four possible points (xn + 1, yn), (xn − 1, yn), (xn, yn + 1) or (xn, yn − 1).</li>
            <li>However, it is forbidden for the point (xn+1, yn+1) to equal one of the points (x0, y0), . . . ,(xn, yn).</li>
            <li>Once a self-avoiding random walk passes through a point, it cannot pass
                through the same point again.</li>
        </ol>
    </li>
    <li>Two or more points in the random walk are not allowed to coincide. </li>
    <li>An example of a self-avoiding random walk is displayed in Fig. 1.
        <ol>
            <li>The walk starts at the origin (0, 0)</li>
            <li>Twelve steps are shown, labelled 1 through 12.</li>
            <li>After step 12, three possible steps labelled 13a, 13b and 13c are shown,</li>
            <li>The step labelled 13a is forbidden because the random walk would intersect itself</li>
            <li>The steps labelled 13b and 13c are allowed.
                <ol>
                    <li>Note that if the next step is 13b, then the random walk reaches a dead end, because
                        all possible steps after that will self-intersect the path of the random walk.</li>
                     <li>It is possible for a self-avoiding random walk to reach a dead end.</li>
                </ol>
            </li>
            <li>There is one additional step after step 12, which is not displayed in Fig. 1.
                <ol>
                    <li>That is to reverse the direction of step 12 and go from (−1, 1) to (−2, 1).</li>
                    <li>A “reverse step” is forbidden because it also counts as a self-intersection.</li>
                </ol>
            </li>
        </ol>
    </li>
    <li>In this project, we shall only consider self-avoiding random walks on integer grids.</li>
    <li>Every random walk always starts at the origin.</li>
    <li> Figure 1</li>
   <img src="https://github.com/Arx1971/Self-Avoiding-Random-Walk-CSCI370/blob/master/LERW.png"
        alt="Self Avoiding Random Walk"
        style="float: left; margin-right: 10px;" />
</ul>

<h2>Result</h2>
<ul>
    <h3>2D Self Avoiding Random Walk</h3>
    <li>The mean (or average) of the end-to-end squared distance is given by the average:
        <img src="https://github.com/Arx1971/Self-Avoiding-Random-Walk-Data-Analysis/blob/master/img_source/2d_R.png"
                    alt="Self Avoiding Random Walk"
                    style="float: left; margin-right: 10px;" />
    </li>
    <h3>3D Self Avoiding Random Walk</h3>
        <li>The mean (or average) of the end-to-end squared distance is given by the average:
            <img src="https://github.com/Arx1971/Self-Avoiding-Random-Walk-Data-Analysis/blob/master/img_source/3d_r.png"
                        alt="Self Avoiding Random Walk"
                        style="float: left; margin-right: 10px;" />
    </li>
     <h3>4D Self Avoiding Random Walk</h3>
             <li>The mean (or average) of the end-to-end squared distance is given by the average:
                 <img src="https://github.com/Arx1971/Self-Avoiding-Random-Walk-Data-Analysis/blob/master/img_source/4d_r.png"
                             alt="Self Avoiding Random Walk"
                             style="float: left; margin-right: 10px;" />
         </li>
          
    
    
     
    
</ul> 
