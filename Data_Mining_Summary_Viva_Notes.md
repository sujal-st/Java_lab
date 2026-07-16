# Data Warehousing & Data Mining — Summary Notes with Viva Questions

---

## Unit 1: Introduction to Data Warehousing

**What it is:** A data warehouse is a subject-oriented, integrated, time-variant, and non-volatile collection of data used to support management decision-making. It pulls data from multiple operational sources, cleans/transforms it, and stores it for analysis (OLAP) rather than day-to-day transactions (OLTP).

**Key topics explained:**
- **Lifecycle of data:** Data moves through stages — generation/collection → storage → processing/cleaning → analysis → usage/archival or deletion.
- **Types of data:** Structured (tables/relational), semi-structured (XML, JSON), unstructured (text, images, video).
- **Data warehouse vs data warehousing:** A data warehouse is the *storage system*; data warehousing is the *entire process* of designing, building, and maintaining it (ETL, modeling, querying).
- **Operational DB vs Data Warehouse:**
  | Feature | Operational DB (OLTP) | Data Warehouse (OLAP) |
  |---|---|---|
  | Purpose | Day-to-day transactions | Analysis & decision support |
  | Data | Current, detailed | Historical, summarized |
  | Design | Normalized (ER model) | Denormalized (star/snowflake) |
  | Users | Clerks, operators | Managers, analysts |
- **Multidimensional data model:** Data viewed as a **cube** with dimensions (e.g., time, product, location) and measures/facts (e.g., sales amount). Built using **star schema** (one fact table + denormalized dimension tables), **snowflake schema** (normalized dimensions), or **fact constellation** (multiple fact tables sharing dimensions).
- **OLAP operations:**
  - **Roll-up** – aggregate data (climb up concept hierarchy, e.g., city→country)
  - **Drill-down** – reverse of roll-up, more detail
  - **Slice** – select one dimension value, reduces cube dimensionality
  - **Dice** – select a sub-cube by specifying values on multiple dimensions
  - **Pivot (rotate)** – reorient the cube view for a different perspective
- **Conceptual modeling:** Star, Snowflake, Fact Constellation schemas.
- **Architecture:** Typically 3-tier — (1) Bottom tier: data sources + ETL, (2) Middle tier: OLAP server (ROLAP/MOLAP/HOLAP), (3) Top tier: front-end tools (query, reporting, data mining tools).
- **Implementation:** Involves ETL (Extract-Transform-Load), indexing (bitmap index), and efficient cube computation.
- **Data marts:** A smaller, department-specific subset of a data warehouse (e.g., sales data mart, HR data mart).
- **Components:** Data sources, ETL tools, data warehouse (storage), metadata repository, OLAP server, front-end/reporting tools.
- **Need for data warehousing:** Consolidates data from many sources, supports historical analysis, improves decision-making, separates analytical load from operational systems.
- **Trends:** Cloud data warehouses, real-time/streaming warehousing, integration with big data (Hadoop/Spark), data lakes, self-service BI.

**Viva Questions:**
1. What is a data warehouse? How is it different from a database?
2. Explain the four characteristics of a data warehouse (subject-oriented, integrated, time-variant, non-volatile).
3. Differentiate OLTP and OLAP.
4. What is a star schema? How is it different from a snowflake schema?
5. Explain roll-up and drill-down with an example.
6. What is slice and dice operation?
7. Describe the 3-tier architecture of a data warehouse.
8. What is a data mart? Why is it needed if we already have a data warehouse?
9. What is ETL? Explain its three steps.
10. What is a fact table and dimension table?

---

## Unit 2: Introduction to Data Mining

**What it is:** Data mining is the process of discovering interesting, previously unknown, and potentially useful patterns from large amounts of data. It's the analysis step of the "Knowledge Discovery in Databases" (KDD) process.

**Key topics explained:**
- **Motivation:** Explosive growth of data ("data rich but information poor"), need to convert data into useful knowledge for business/science decisions.
- **Data mining system:** A system that integrates a database/data warehouse with mining algorithms and a user interface for pattern discovery.
- **Functionalities:**
  - **Descriptive:** characterization, discrimination, association/correlation analysis, clustering, outlier analysis
  - **Predictive:** classification, regression, prediction
- **KDD (Knowledge Discovery in Databases):** Steps — Data cleaning → Data integration → Data selection → Data transformation → **Data mining** → Pattern evaluation → Knowledge presentation.
- **Data object and attribute types:**
  - Nominal (categorical, no order — e.g., color)
  - Binary (two states — symmetric/asymmetric)
  - Ordinal (ordered categories — e.g., rank)
  - Numeric: Interval-scaled and Ratio-scaled
- **Statistical description of data:** Measures of central tendency (mean, median, mode) and dispersion (range, variance, standard deviation, quartiles, boxplots) used to understand data distribution before mining.
- **Issues:** Mining methodology (handling noise, high dimensionality), user interaction, performance/scalability, and diverse data types.
- **Applications:** Market analysis, fraud detection, healthcare/bioinformatics, recommendation systems, intrusion detection.

**Viva Questions:**
1. Define data mining. Why is it needed?
2. What is KDD? List its steps.
3. Differentiate data mining from KDD.
4. What are the different functionalities of data mining? (descriptive vs predictive)
5. Differentiate nominal, ordinal, interval, and ratio attributes.
6. What are the major issues in data mining?
7. Give real-world applications of data mining.
8. What is the difference between classification and clustering?

---

## Unit 3: Data Preprocessing

**What it is:** Real-world data is often incomplete, noisy, and inconsistent. Preprocessing improves data quality before mining, since "garbage in, garbage out."

**Key topics explained:**
- **Data cleaning:** Handling missing values (ignore tuple, fill manually, use mean/median/mode, or use a predicted value), noisy data (binning, regression, clustering to detect outliers).
- **Data integration:** Combining data from multiple sources; handling issues like entity identification, redundancy (correlation analysis, chi-square test), and detecting/resolving data value conflicts.
- **Data transformation:** Smoothing, aggregation, generalization, **normalization** (min-max, z-score, decimal scaling), attribute construction.
- **Data reduction:** Reduce data volume while keeping analytical results the same:
  - **Dimensionality reduction:** PCA (Principal Component Analysis), attribute subset selection
  - **Numerosity reduction:** Regression, histograms, clustering, sampling
  - **Data compression**
- **Data discretization & concept hierarchy generation:** Converting continuous attributes into discrete intervals (binning, histogram analysis, cluster/entropy-based discretization); building hierarchies (e.g., day → month → year) to allow mining at multiple abstraction levels.
- **Data mining primitives:** The basic components needed to specify a mining task — task-relevant data, kind of knowledge to mine, background knowledge (concept hierarchies), interestingness measures, and presentation/visualization method.

**Viva Questions:**
1. Why is data preprocessing necessary?
2. What are the different methods to handle missing data?
3. Explain binning method for smoothing noisy data.
4. What is normalization? Explain min-max and z-score normalization with formulas.
5. Differentiate dimensionality reduction and numerosity reduction.
6. What is PCA? How does it help in data reduction?
7. What is concept hierarchy? Give an example.
8. What are data mining primitives?
9. How is redundancy detected during data integration? (Chi-square/correlation)

---

## Unit 4: Data Cube Technology

**What it is:** Techniques for efficiently computing and storing multidimensional data cubes used in OLAP, since computing a full cube over many dimensions can be extremely expensive.

**Key topics explained:**
- **Efficient cube computation methods:** Multiway array aggregation, BUC (Bottom-Up Computation), Star-Cubing — algorithms designed to avoid redundant computation and use sorting/partitioning to speed up aggregation.
- **Cube materialization:**
  - **Full cube:** Precompute and store all possible aggregations (most storage, fastest query)
  - **Iceberg cube:** Only compute cells above a minimum support threshold (saves space by ignoring sparse/insignificant cells)
  - **Closed cube:** Store only "closed" cells — a cell is closed if no descendant has the same measure value (removes redundancy)
  - **Shell cube (cube shell):** Precompute only a small subset of low-dimensional cuboids (the "shell"); higher-order combinations computed on the fly
- **General strategies for cube computation:** Sorting, hashing, grouping dimensions; ordering dimensions to share partial computation; caching intermediate results; using simultaneous aggregation.
- **Attribute-Oriented Induction (AOI):** A method of data characterization/generalization — it summarizes data by climbing concept hierarchies attribute by attribute, replacing low-level values with higher-level concepts.
- **Mining class comparison / discrimination:** Comparing two or more classes of data (the "target class" vs "contrasting class") to find features that distinguish them — e.g., comparing profiles of loan-approved vs loan-rejected customers.

**Viva Questions:**
1. What is a data cube? Why is efficient computation of cubes important?
2. Differentiate full cube, iceberg cube, closed cube, and shell cube.
3. What is an iceberg cube? What is the role of the minimum support threshold?
4. Explain the Attribute-Oriented Induction approach.
5. What is the difference between class characterization and class comparison (discrimination)?
6. What are cuboids? What is a lattice of cuboids?
7. Name algorithms used for efficient cube computation.

---

## Unit 5: Mining Frequent Patterns

**What it is:** Frequent pattern mining finds itemsets, subsequences, or substructures that occur frequently together in a dataset — foundational for association rule mining (e.g., market basket analysis).

**Key topics explained:**
- **Frequent patterns:** Patterns (itemsets, sequences) that appear frequently (≥ minimum support) in a dataset.
- **Market basket analysis:** Classic application — analyzing customer purchase data to find items frequently bought together (e.g., "bread → butter").
- **Frequent itemsets:** A set of items whose support ≥ minsup.
- **Closed itemsets:** A frequent itemset is closed if none of its immediate supersets has the same support count — reduces redundancy while preserving information.
- **Association rules:** Rules of the form A → B with **support** (how often A and B occur together) and **confidence** (how often B occurs given A).
- **Types of association rules:**
  - Single-dimensional (one attribute, e.g., buys)
  - Multidimensional (multiple attributes, e.g., age + income + buys)
  - Multilevel (rules at different concept-hierarchy levels, e.g., "milk" vs "skim milk")
  - Quantitative (involves numeric attributes, e.g., age between 20–30)
- **Apriori algorithm:** Uses the **Apriori property** ("all subsets of a frequent itemset must be frequent") to iteratively generate candidate itemsets level by level, pruning infrequent ones, then scanning the database to count support.
- **FP-Growth:** Builds a compact **FP-tree** (Frequent Pattern tree) from the dataset and mines frequent itemsets directly without candidate generation — much faster than Apriori for large/dense datasets.
- **Generating association rules:** From each frequent itemset, generate all non-empty subsets and form rules that meet minimum confidence.
- **Limitations of Apriori & improvements:** Apriori requires multiple database scans and generates huge candidate sets; improvements include hash-based counting, transaction reduction, partitioning, sampling, and dynamic itemset counting — FP-Growth avoids candidate generation altogether.
- **From association to correlation analysis:** Support-confidence alone can be misleading (a rule can have high confidence but be negatively correlated). **Lift** measures this: Lift(A,B) = P(A∪B) / (P(A) × P(B)). Lift = 1 means independent, >1 means positively correlated, <1 means negatively correlated.

**Viva Questions:**
1. Define support and confidence with an example.
2. Explain the Apriori algorithm with an example (Apriori property).
3. What are the limitations of the Apriori algorithm?
4. How does FP-Growth improve upon Apriori?
5. What is an FP-tree? How is it constructed?
6. Differentiate frequent itemset and closed itemset.
7. What is multilevel and multidimensional association rule mining?
8. What is Lift? Why is confidence alone not sufficient to judge rule strength?
9. Explain market basket analysis with a real example.

---

## Unit 6: Classification and Prediction

**What it is:** Classification predicts a **categorical (discrete) class label** (e.g., spam/not spam), while prediction (regression) predicts a **continuous numeric value** (e.g., sales next quarter). Both are supervised learning tasks built from labeled training data.

**Key topics explained:**
- **Learning and testing:** Model is built (trained) on a **training set** and evaluated on a separate **test set** to check how well it generalizes.
- **Decision tree induction (ID3):** Builds a tree where internal nodes test an attribute, branches represent outcomes, and leaves represent class labels. **ID3** selects the best splitting attribute at each node using **Information Gain** (based on entropy) — the attribute that most reduces uncertainty is chosen.
- **Bayesian classification:** Based on **Bayes' theorem**: P(C|X) = P(X|C)P(C)/P(X). **Naïve Bayes** assumes attributes are conditionally independent given the class, simplifying computation.
- **Laplace smoothing:** Adds a small constant to probability estimates to avoid zero probability when an attribute value never appears with a class in training data.
- **Classification by backpropagation:** Uses a multi-layer neural network; errors are propagated backward from output to input layers, adjusting weights (via gradient descent) to minimize prediction error.
- **Rule-based classifier:**
  - **Decision tree → rules:** Each root-to-leaf path becomes an IF-THEN rule.
  - **Rule coverage & accuracy:** Coverage = fraction of tuples satisfying the rule's condition; Accuracy = fraction of covered tuples correctly classified.
  - **Rule pruning/simplification:** Removes unnecessary conditions to reduce overfitting and improve generalization.
- **Support Vector Machine (SVM):** Finds the optimal **hyperplane** that maximizes the margin between classes; uses **support vectors** (closest points to the boundary); kernel functions handle non-linearly separable data.
- **Evaluating accuracy:**
  - **Precision** = TP/(TP+FP) — correctness of positive predictions
  - **Recall** = TP/(TP+FN) — coverage of actual positives
  - **F-measure** = harmonic mean of precision and recall
- **Overfitting vs underfitting:** Overfitting = model too complex, fits training noise, performs poorly on new data. Underfitting = model too simple, fails to capture patterns even in training data.
- **K-fold cross-validation:** Data split into K parts; model trained on K-1 folds and tested on the remaining fold, repeated K times and results averaged — gives a more reliable accuracy estimate.
- **Comparing two classifiers – McNemar's test:** A statistical test used to compare the performance of two classifiers on the same test set, checking if the difference in errors is statistically significant.

**Viva Questions:**
1. Differentiate classification and prediction.
2. Explain decision tree induction using ID3. What is Information Gain?
3. What is entropy? How is it used in attribute selection?
4. Explain Naïve Bayes classifier with an example.
5. Why is Laplace smoothing needed?
6. What is backpropagation? Briefly explain how it trains a neural network.
7. What is a support vector machine? What are support vectors?
8. Define precision, recall, and F-measure with formulas.
9. What is overfitting? How can it be avoided (pruning, cross-validation)?
10. Explain K-fold cross-validation.
11. What is McNemar's test used for?
12. How do you convert a decision tree into rules?

---

## Unit 7: Cluster Analysis

**What it is:** Clustering is unsupervised learning — grouping a set of objects such that objects in the same cluster are more similar to each other than to those in other clusters (no predefined labels).

**Key topics explained:**
- **Types of data in cluster analysis:** Interval-scaled, binary, nominal/ordinal, and mixed-type variables.
- **Similarity/dissimilarity measures:** Euclidean distance, Manhattan distance, Minkowski distance, cosine similarity, Jaccard coefficient (for binary/categorical data).
- **Partitioning methods:**
  - **K-means:** Randomly picks K initial centroids, assigns points to nearest centroid, recomputes centroids, repeats until convergence. Sensitive to outliers and initial centroid choice.
  - **K-means++:** Improves initial centroid selection (spreads them out probabilistically) to get better/faster convergence than plain K-means.
  - **Mini-Batch K-means:** Uses small random batches of data per iteration instead of the full dataset — much faster on large datasets, slight accuracy trade-off.
  - **K-medoids (PAM):** Uses actual data points (medoids) as cluster centers instead of means — more robust to outliers/noise than K-means.
- **Hierarchical methods:**
  - **Agglomerative (bottom-up):** Starts with each object as its own cluster, repeatedly merges the closest pair of clusters until one cluster remains.
  - **Divisive (top-down):** Starts with all objects in one cluster, repeatedly splits it into smaller clusters.
  - Produces a **dendrogram** showing the merge/split hierarchy.
- **Density-based clustering (DBSCAN):** Groups points that are closely packed (dense regions), marking points in low-density regions as outliers. Uses two parameters: **eps** (radius) and **minPts** (minimum points to form a dense region). Can find arbitrarily shaped clusters and doesn't require specifying K in advance.
- **Outlier analysis:** Identifying data objects that deviate significantly from the rest — approaches include statistical (distribution-based), distance-based, density-based (e.g., LOF), and clustering-based outlier detection.

**Viva Questions:**
1. What is clustering? How does it differ from classification?
2. Explain the K-means algorithm step by step.
3. What are the drawbacks of K-means, and how does K-means++ fix the initialization problem?
4. Differentiate K-means and K-medoids.
5. What is the difference between agglomerative and divisive hierarchical clustering?
6. What is a dendrogram?
7. Explain DBSCAN. What are "eps" and "minPts"?
8. What is the advantage of density-based clustering over partitioning methods?
9. What is an outlier? How can outliers be detected?
10. Name common distance/similarity measures used in clustering.

---

## Unit 8: Graph Mining and Social Network Analysis

**What it is:** Techniques to discover patterns, structures, and relationships within graph-structured data (networks of nodes and edges), such as social networks.

**Key topics explained:**
- **Graph mining:** Extracting frequent subgraph patterns, structural rules, and relationships from graph data (e.g., molecular structures, social graphs).
- **Why graph mining:** Many real-world relationships (social ties, web links, biological networks) are naturally represented as graphs; relational/tabular mining methods can't capture structural/topological information.
- **Graph mining algorithms:**
  - **Beam search:** A heuristic search that explores a graph/pattern space keeping only the top-k most promising candidates at each step (limits search space for efficiency).
  - **Inductive Logic Programming (ILP):** Uses logic-based representations to learn rules/patterns from relational/graph data, combining machine learning with first-order logic.
- **Social network analysis (SNA):** Study of relationships/structure in social networks using graph theory (nodes = people/entities, edges = relationships).
- **Link mining:** Discovering patterns in relationships (links) between objects — includes link prediction, classification using links, and community detection.
- **Friends of friends:** Concept used to discover indirect relationships/recommend new connections by traversing a node's neighbors' neighbors.
- **Degree assortativity:** A measure of whether nodes tend to connect to other nodes with similar degree (high-degree nodes connect to high-degree nodes) — positive assortativity vs. disassortativity.
- **Signed networks:** Networks where edges carry a sign (+ trust/friendship, − distrust/enmity).
  - **Theory of structural balance:** Studies whether triads (3 nodes) are "balanced" (e.g., friend of friend is friend) — balanced triads are more stable.
  - **Theory of status:** Signed edges interpreted as status differences ("I trust you" implies you have higher status).
  - **Conflict between balance and status theory:** In certain triad configurations, the balance-based prediction of a sign and the status-based prediction disagree.
- **Trust in a network:**
  - **Atomic propagation:** Basic rule for how trust propagates directly through one link.
  - **Propagation of distrust:** How negative trust/distrust spreads differently (and more complexly) than positive trust.
  - **Iterative propagation:** Trust values are repeatedly recalculated/propagated across the network until they stabilize (converge).
- **Predicting positive and negative links:** Using structural balance/status theories and machine learning to predict whether an unknown or future link will be positive (trust) or negative (distrust).

**Viva Questions:**
1. What is graph mining? Why is it needed in addition to traditional data mining?
2. Explain beam search in graph pattern mining.
3. What is Social Network Analysis (SNA)?
4. What is link mining? Give examples of link mining tasks.
5. What is degree assortativity?
6. Explain the theory of structural balance with an example triad.
7. Differentiate the theory of balance and the theory of status.
8. How does trust propagate in a network (atomic vs iterative propagation)?
9. Why is propagation of distrust more complex than propagation of trust?
10. How can positive/negative links be predicted in a signed network?

---

## Unit 9: Mining Spatial, Multimedia, Text and Web Data

**What it is:** Specialized data mining techniques for complex, non-traditional data types — spatial (geographic), multimedia (image/audio/video), text, and web data.

**Key topics explained:**
- **Spatial data mining:** Discovering patterns from spatial (geographic/location-based) data — e.g., finding regions with high crime rates.
- **Spatial data cube:** Extension of a data cube where dimensions include spatial attributes (e.g., regions, coordinates), allowing spatial OLAP.
- **Mining spatial association:** Finding association rules involving spatial relationships (e.g., "houses near a lake tend to be expensive").
- **Multimedia data mining:** Extracting patterns from image, audio, and video data.
- **Similarity search in multimedia:** Finding multimedia objects similar to a query object, typically using feature vectors (color histograms, shape descriptors) and distance measures.
- **Mining association in multimedia data:** Finding co-occurrence patterns among multimedia features (e.g., objects that frequently appear together in images).
- **Text mining / NLP / information extraction:** Text mining extracts useful patterns/knowledge from unstructured text; **NLP** enables understanding of human language (tokenization, parsing, sentiment analysis); **Information Extraction** pulls structured facts (entities, relationships) out of unstructured text.
- **Web mining:**
  - **Web content mining:** Extracting useful information/patterns from the actual content of web pages (text, images).
  - **Web structure mining:** Analyzing the link structure between web pages (e.g., PageRank) to discover relationships/authority.
  - **Web usage mining:** Analyzing web server logs / user click-streams to understand user behavior patterns.

**Viva Questions:**
1. What is spatial data mining? Give an example.
2. What is a spatial data cube?
3. What is multimedia data mining? How is similarity search performed?
4. Differentiate text mining from information extraction.
5. What is web mining? Differentiate web content, structure, and usage mining.
6. Give a real-life example of web structure mining (e.g., PageRank).
7. What challenges are unique to mining spatial/multimedia data compared to relational data?

---

## Quick Cross-Unit Viva Questions (Frequently Asked)
1. What is the difference between data mining and data warehousing?
2. Why do we need data preprocessing before applying data mining algorithms?
3. Compare Apriori and FP-Growth in terms of efficiency.
4. Compare classification and clustering with one example each.
5. What are the main steps of the KDD process, and where does "data mining" fit in?
6. Give one real-world business use case for each: association rules, classification, clustering.
7. What is the curse of dimensionality, and how does data reduction help?
8. Explain any two OLAP operations with examples.
9. What is overfitting, and which techniques (pruning, cross-validation, regularization) help prevent it?
10. Compare supervised learning (classification) and unsupervised learning (clustering).

---
*Compiled as an exam/viva revision reference based on the standard Data Mining & Data Warehousing syllabus (hamrocsit.com).*
