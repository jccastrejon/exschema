#### ExSchema: Discovering and Maintaining Schemas from Polyglot Persistence Applications ####
* * *

##### Introduction #####
The use of scalable and heterogeneous data stores within a single system is gradually becoming a common practice in application development. Modern applications tend to rely on a polyglot approach to persistence, where traditional databases, non-relational data stores, and scalable systems associated to the emerging NewSQL movement, are used simultaneously.

However, due to the schema-less nature of most of these scalable data stores, developers in charge of maintaining systems that rely on them are usually required to manually analyze their full source code in order to recover the implicit schemas that these applications rely upon.

To help overcome this situation, in this paper we demonstrate ExSchema, a tool intended for the automatic discovery of data schemas, directly from the source code of polyglot persistence applications. Our tool can also be integrated with existing Git repositories, in order to analyze the evolution of the schemas used by an application over a period of time. ExSchema is available as an Eclipse plugin, and can be easily included within existing development environments. In particular, our tool presents a demonstration scenario where the schemas from a web system that relies on multiple document, graph, relational and column-family data stores, are discovered directly from the application source code.
- - - - 

##### Presentation #####
The following [presentation](http://www.slideshare.net/jccastrejon/exschema-16835399) contains an overview of the ExSchema project.
- - - - 

##### Demonstration #####
Demonstration on a polyglot persistence application (JPA+Neo4j+MongoDB+HBase) and its associated Git repository.

* [Detailed demonstration](http://www.youtube.com/watch?feature=player_embedded&v=2VuIJOkoZrg) (~12min).

* Are you in a hurry?. Here's a [shorter version of the demonstration](http://www.youtube.com/watch?feature=player_embedded&v=h-fFmbT_btk) (~3min).

- - - - 

##### Installation #####
1. Install the latest distribution of [Eclipse](http://www.eclipse.org/downloads/)
2. Install [Graphviz](http://www.graphviz.org/Download..php) (If you're using Ubuntu, you can rely on the Ubuntu Software Center to retrieve the latest stable version)
3. Inside Eclipse, install the ExSchema plugin (Help->Install New Software->Add...) using the following update site: http://exschema.googlecode.com/git/fr.imag.exschema.update.site/

- - - - 

##### Tests #####
You can test our tool with the following [test applications](http://exschema.googlecode.com/files/ExSchema-tests-0.1.4.zip) (14 open source+2 industrial). The ExSchema results are inside each project, in the exschema_results directory.

###### Notes ######
We have tested the latest implementation on Mac OS X 10.8 and on Ubuntu 12.04
If you'd like to execute the generated Spring Roo scripts, you'll also need to install [Spring Roo](http://www.springsource.org/spring-roo)
- - - - 

##### Reference #####
Castrejón, J., Vargas-Solar, G., Collet, C., Lozano, R.,: “ExSchema: Discovering and Maintaining Schemas from Polyglot Persistence Applications”. In: 29th IEEE International Conference on Software Maintenance (ICSM 2013). To be published.

Note: A public version of this paper can be found [right here](https://exschema.googlecode.com/files/ExSchema-icsm.pdf).
