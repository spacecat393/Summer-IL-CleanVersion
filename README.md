# Build
<span style="font-size: large; ">

- Set up and build [Nali-Library](https://github.com/spacecat393/Nali-Library)
- Set up and build [Small-Library](https://github.com/spacecat393/Small-Library)
- Set up and build [Extra](https://github.com/spacecat393/Extra)
- Set up Summer [TemplateDevEnv](https://github.com/CleanroomMC/TemplateDevEnv)
>build.gradle
```groovy
dependencies
{
	//...

	implementation rfg.deobf(files('../Nali-Library/build/libs/nali.jar'))
    implementation rfg.deobf(files('../Small-Library/build/libs/small.jar'))
    implementation rfg.deobf(files('../Extra/build/libs/extra.jar'))
}
```
>gradle.properties
```properties
mod_version = 2.2.0
root_package = com.nali
mod_id = summer
mod_name = Summer

use_mixins = true

generate_mixins_json = false

is_coremod = true
coremod_plugin_class_name = com.nali.${mod_id}.Core
```
</span>