addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.8.3")

resolvers += Resolver.url("sbt-plugin-releases",
  new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)


//libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-proguard-plugin" % (v+"-0.1.1"))

//resolvers += "Proguard plugin repo" at "http://siasia.github.com/maven2"
