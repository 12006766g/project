student id: 12006766g
student name: Man Pak Hong
git hub location: https://github.com/12006766g/project


1. please change the eclipse to the runtime library which your eclipse have
2. ensure java build path JRE System Library is jdk1.8.0_31 and doesn't have error

3. right-click the project -> Project Facets ->
 ensure java is version 1.8
and
 Runtimes -> jdk 1.8.0_31
jdk: jdk 1.8.0_31
4. please use maven build to get all the packages to your repository by: 
right-click project -> Run as -> maven build -> enter the goal as "package"
5. you can run ant build or maven build as you like once maven get all the dependencies